package xyz.sadli.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.jsonwebtoken.lang.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import xyz.sadli.common.Constants;
import xyz.sadli.common.ErrCodeEnums;
import xyz.sadli.dao.JtBannerMapper;
import xyz.sadli.entity.JtBanner;
import xyz.sadli.entity.JtStorage;
import xyz.sadli.query.banner.BannerPageQuery;
import xyz.sadli.service.JtBannerService;
import xyz.sadli.service.JtStorageService;
import xyz.sadli.util.IdWorker;
import xyz.sadli.vo.JtBannerVO;

import java.util.Date;
import java.util.List;

/**
 * About:
 * Other:
 * Created: lwf14 on 2023/3/8 20:52.
 * Editored:
 */
@Service
public class JtBannerServiceImpl implements JtBannerService {

    public static final Logger log = LoggerFactory.getLogger(JtBannerServiceImpl.class);

    private final JtBannerMapper bannerMapper;

    private final JtStorageService storageService;

    public JtBannerServiceImpl(JtBannerMapper bannerMapper, JtStorageService storageService) {
        this.bannerMapper = bannerMapper;
        this.storageService = storageService;
    }

    @Override
    public PageInfo<JtBannerVO> queryBannerPageList(BannerPageQuery query) {
        PageHelper.startPage(query.getPage(), query.getLimit());
        List<JtBannerVO> voList = bannerMapper.selectBannerVOListByQuery(query);
        return new PageInfo<>(voList);
    }

    @Override
    @Transactional
    public JtBannerVO uploadBanner(MultipartFile file, String creator) {
        //TODO 校验是否是系统支持的视频格式
        //为什么要加这一步，因为storageService里面的upload方法供整个系统使用，支持很多类型的文件上传，所以要前置处理一下
        JtStorage storage = storageService.upload(file, creator, Constants.RESOURCE_TYPE_BANNER);
        JtBanner banner = new JtBanner();
        String nextIdStr = IdWorker.nextIdStr();
        banner.setBannerId(nextIdStr);
        banner.setStorageId(storage.getId());
        banner.setOriginName(file.getOriginalFilename());
        banner.setDescription("");
        // 如果当前生效的视频不存在，则该视频状态默认为生效展示，否则该视频状态保存为未生效
        banner.setShowStatus(bannerMapper.selectCurrentShowedBanner() == null ? Constants.STATUS_VALID : Constants.STATUS_INVALID);
        banner.setCreateTime(storage.getCreateTime());
        bannerMapper.insert(banner);
        return new JtBannerVO(banner, storage);
    }

    @Override
    public void removeBanner(String bannerId) {
        JtBanner b = bannerMapper.selectByPrimaryKey(bannerId);
        Assert.notNull(b, ErrCodeEnums.NON_FILE_EXCEPTION.getMsg());
        b.setShowStatus(Constants.BANNER_DELETED);
        b.setUpdateTime(new Date());
        bannerMapper.updateByPrimaryKey(b);
    }

    @Override
    @Transactional
    public void editBannerShow(String bannerId) {
        JtBanner banner = bannerMapper.selectByPrimaryKey(bannerId);
        Assert.notNull(banner, ErrCodeEnums.NON_FILE_EXCEPTION.getMsg());
        Date date = new Date();
        banner.setShowStatus(Constants.STATUS_VALID);
        banner.setUpdateTime(date);
        // 更新要展示的banner状态为1
        bannerMapper.updateByPrimaryKey(banner);
        JtBanner showedBanner = bannerMapper.selectCurrentShowedBanner();
        if (showedBanner != null) {
            showedBanner.setShowStatus(Constants.STATUS_INVALID);
            showedBanner.setUpdateTime(date);
            // 更新当前展示的banner状态为0
            // 两个更新操作必须是原子性的
            bannerMapper.updateByPrimaryKeySelective(showedBanner);
        }
    }
}
