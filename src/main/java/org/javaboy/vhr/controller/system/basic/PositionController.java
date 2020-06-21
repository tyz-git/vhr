package org.javaboy.vhr.controller.system.basic;

import org.javaboy.vhr.model.Position;
import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.service.system.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * @author: TongYaZhou
 * @create: 2020-06-06 17:58
 * 职位相关功能
 **/
@RestController
@RequestMapping(value = "/system/basic/position")
public class PositionController {

    @Autowired
    PositionService positionService;

    @GetMapping(value = "/")
    public RespBean getPositionList(){
        List<Position> positionList =  positionService.getPositionList();
        if (!Objects.isNull(positionList)){
            return RespBean.success("获取职位列表成功",positionList, "false");
        }
        return RespBean.error("获取职位列表失败!");
    }

    @PostMapping(value = "/")
    public RespBean addPosition(@RequestBody Position position){
        int result = positionService.addPositionSelective(position);
        if (result > 0){
            return RespBean.success("添加职位成功!");
        }
        return RespBean.error("添加职位失败!");
    }

    @PutMapping(value = "/")
    public RespBean updatePosition(@RequestBody Position position){
        int result = positionService.updatePositionByPrimaryKeySelective(position);
        if (result > 0){
            return RespBean.success("修改职位成功!");
        }
        return RespBean.error("修改职位失败!");
    }

    @DeleteMapping(value = "/{id}")
    public RespBean deletePositionByPrimaryKey(@PathVariable Integer id){
        int result = positionService.deletePositionByPrimaryKey(id);
        if (result > 0){
            return RespBean.success("删除职位成功!");
        }
        return RespBean.error("删除职位失败!");
    }

    @DeleteMapping(value = "/")
    public RespBean deletePositions(Integer[] ids){
        int result = positionService.deletePositions(ids);
        if (result == ids.length){
            return RespBean.success("批量删除职位成功!");
        }
        return RespBean.error("批量删除职位失败!");
    }


}
