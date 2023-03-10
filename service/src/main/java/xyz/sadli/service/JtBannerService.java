package xyz.sadli.service;

import com.github.pagehelper.PageInfo;
import org.springframework.web.multipart.MultipartFile;
import xyz.sadli.query.banner.BannerPageQuery;
import xyz.sadli.vo.JtBannerVO;

/**
 * About:
 * Other:
 * Created: lwf14 on 2023/3/8 20:52.
 * Editored:
 */
public interface JtBannerService {

    /**
     * 分页查询Banner视频列表
     *
     * @param query
     * @return
     */
    PageInfo<JtBannerVO> queryBannerPageList(BannerPageQuery query);

    /**
     * Banner视频上传
     *
     * @param file
     * @param creator
     * @return
     */
    JtBannerVO uploadBanner(MultipartFile file, String creator);

    /**
     * 删除banner
     *
     * @param bannerId
     */
    void removeBanner(String bannerId);

    /**
     * 修改banner状态为首页展示
     *
     * @param bannerId
     */
    void editBannerShow(String bannerId);
}
