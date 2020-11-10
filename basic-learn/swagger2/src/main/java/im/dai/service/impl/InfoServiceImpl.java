package im.dai.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import im.dai.entity.Info;
import im.dai.mapper.InfoMapper;
import im.dai.service.InfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: roc
 * @date: 2020/9/15 下午 06:18
 * @description: TODO
 */
@Service("infoService")
public class InfoServiceImpl implements InfoService {
    @Resource
    private InfoMapper infoMapper;


    @Override
    public List<Info> selectPage(Integer current, Integer size) {
        //参数1：当前页 默认值是1    参数2：记录数 默认值是10
        IPage<Info> page = new Page<>(current,size);
        IPage<Info> infoIPage = infoMapper.selectPage(page, null);
        return infoIPage.getRecords();
    }

    @Override
    public void insert(Info info) {
        infoMapper.insert(info);
    }

    @Override
    public void updateById(Info info) {
        infoMapper.updateById(info);
    }

    @Override
    public void deleteById(Integer id) {
        infoMapper.deleteById(id);
    }
}
