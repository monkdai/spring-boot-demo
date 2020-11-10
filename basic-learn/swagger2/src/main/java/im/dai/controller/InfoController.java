package im.dai.controller;

import im.dai.entity.Info;
import im.dai.service.InfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: roc
 * @date: 2020/9/15 下午 06:16
 * @description: TODO
 */
@Api(tags = "信息管理")
@RestController
@RequestMapping(value = "/info")
public class InfoController {
    @Resource(name = "infoService")
    private InfoService infoService;

    //插入
    @ApiOperation(value = "增加信息")
    @PostMapping("/add")
    public void insert(@RequestBody Info info){
        //info.setName("徐八").setTel(888).setPwd("888");
        infoService.insert(info);
    }

    //修改
    //基于主键id进行数据的修改
    @ApiOperation(value = "修改信息")
    @PutMapping("/edit")
    public void updateById(@RequestBody Info info){
        infoService.updateById(info);
    }

    //删除
    //基于主键id进行数据的删除
    @ApiOperation(value = "删除信息")
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id){
        infoService.deleteById(id);
    }

    //基于条件进行删除
    //public void delete(){
    //    QueryWrapper<Info> queryWrapper = new QueryWrapper<>();
    //    queryWrapper.lt("tel",111);
    //    infoService.delete(queryWrapper);
    //}

    //分页查询
    @ApiOperation(value = "分页查询")
    @GetMapping("/all")
    public List<Info> findPage(@RequestParam(value = "page",required = true) Integer page
            ,@RequestParam(value = "size",required = true) Integer size){
        return infoService.selectPage(page,size);
    }
    //查询所有
    //public void findAll(){
    //    List<Info> infos = infoService.selectList(null);    //null不给条件：查询所有数据
    //    infos.forEach(info -> System.out.println("info = " + info));
    //}

    //根据主键查询一个
    //public void findById(){
    //    Info info = infoService.selectById("2");
    //    System.out.println("info= " + info);
    //}

    //条件查询
    //public void find(){
    //    QueryWrapper<Info> queryWrapper = new QueryWrapper<>();
    //
    //    //queryWrapper.eq("tel",222); //设置等值查询
    //    //queryWrapper.lt("tel",222); //设置小于查询
    //    queryWrapper.le("tel",222); //设置小于等于
    //
    //    List<Info> infos =  infoService.selectList(queryWrapper);
    //    infos.forEach(info -> System.out.println(info));
    //}

    //模糊查询
    //public void findLike(){
    //    QueryWrapper<Info> queryWrapper = new QueryWrapper<>();
    //
    //    //like: %?%
    //    queryWrapper.like("name","王");
    //    List<Info> infos = infoService.selectList(queryWrapper);
    //    infos.forEach(info -> System.out.println(info));
    //
    //    //likeLeft: %?
    //    //likeRight: ?%
    //}

}
