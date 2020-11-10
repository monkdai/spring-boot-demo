package im.dai.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author: roc
 * @date: 2020/9/15 下午 06:16
 * @description: TODO
 */
@Data
@AllArgsConstructor  //有参构造
@NoArgsConstructor  //无参构造
@ToString   //toString方法
@Accessors(chain = true)
@TableName(value = "info")  //实体类名和表名的映射, 默认是类名
@ApiModel(value = "信息实体")
public class Info {
    @ApiModelProperty("1")
    @TableId(value = "id",type = IdType.AUTO)    //当前属性为表的主键, 此时不指定也可以, AUTO:ID自增
    private Integer id;

    @ApiModelProperty("2")
    @TableField(value = "name") //匹配name字段名
    private String name;

    @ApiModelProperty("4")
    private Integer tel;

    @ApiModelProperty("3")
    private String pwd;

    //@TableField(exist = false)  //aaa不映射数据库的任何字段
    //private String aaa;
}