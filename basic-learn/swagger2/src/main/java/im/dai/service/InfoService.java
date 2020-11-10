package im.dai.service;

import im.dai.entity.Info;

import java.util.List;

/**
 * @author: roc
 * @date: 2020/9/15 下午 06:17
 * @description: TODO
 */
public interface InfoService {
    List<Info> selectPage(Integer current, Integer size);

    //插入
    void insert(Info info);

    //修改
    void updateById(Info info);

    //删除
    void deleteById(Integer id);
}