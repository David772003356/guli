package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.rest.ObjectRestResponse;
import com.atguigu.commonutils.rest.RestCode;
import com.atguigu.commonutils.rest.RestMsg;
import com.atguigu.commonutils.rest.TableResultResponse;
import com.atguigu.commonutils.utils.UUIDUtils;
import com.atguigu.eduservice.dto.TeacherDTO;
import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.service.EduTeacherService;
import com.atguigu.servicebase.handler.GuliException;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-08-14
 */
@Api(value = "EduTeacherController",description = "教师模块")
@CrossOrigin   // 跨域配置    浏览器从一个域名的网页去请求另一个域名的资源时，域名、端口、协议任一不同，都是跨域 。前后端分离开发中，需要考虑ajax跨域的问题。这里我们可以从服务端解决这个问题
@RestController
@RequestMapping("/eduservice/teacher")
@Slf4j
public class EduTeacherController {

    @Autowired
    private EduTeacherService teacherService;

    @ApiOperation("分页查询所有教师")
    @PostMapping("listByPage")
    public TableResultResponse list(@RequestBody TeacherDTO teacherDTO){
        Page<EduTeacher> pageParam = new Page<>(teacherDTO.getPageNum(), teacherDTO.getPageSize());
        try {
            int i=1/0;
        } catch (Exception e) {
            throw new GuliException(100,e.getMessage());
        }

        teacherService.page(pageParam, null);
//        List<EduTeacher> list = teacherService.list(null);
       return new TableResultResponse(pageParam.getTotal(),pageParam.getRecords());
    }

    @ApiOperation("根据id逻辑删除")
    @DeleteMapping("{id}")
    public ObjectRestResponse removeById(@ApiParam(name = "id", value = "讲师ID", required = true)@PathVariable String id){
        teacherService.removeById(id);
        return new ObjectRestResponse().message(RestMsg.SUCCESS_MSG).status(RestCode.SUCCESS);
    }


    @ApiOperation("保存教师")
    @PostMapping("/saveTeacher")
    public ObjectRestResponse saveTeacher(@RequestBody TeacherDTO teacherDTO){
        EduTeacher eduTeacher = new EduTeacher();
        eduTeacher.setId(UUIDUtils.generateUuidOf8());
        eduTeacher.setName(teacherDTO.getName());
        eduTeacher.setIntro(teacherDTO.getIntro());
        eduTeacher.setCareer(teacherDTO.getCareer());
        eduTeacher.setLevel(teacherDTO.getLevel());
        eduTeacher.setAvatar(teacherDTO.getAvatar());
        eduTeacher.setSort(teacherDTO.getSort());
        eduTeacher.setIsDeleted(false);
        teacherService.save(eduTeacher);
        return new ObjectRestResponse().message(RestMsg.SUCCESS_MSG).status(RestCode.SUCCESS);
    }

    @ApiOperation(value = "根据ID修改讲师")
    @PutMapping("{id}")
    public ObjectRestResponse updateById(
            @ApiParam(name = "id", value = "讲师ID", required = true)
            @PathVariable String id,
            @ApiParam(name = "teacher", value = "讲师对象", required = true)
            @RequestBody EduTeacher teacher){
        teacher.setId(id);
        teacherService.updateById(teacher);
        return new ObjectRestResponse().message(RestMsg.SUCCESS_MSG);
    }
}

