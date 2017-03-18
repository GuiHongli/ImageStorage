package imageStorage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import imageStorage.entity.Projectlist;
import imageStorage.entity.ProjectlistExample;
import imageStorage.entity.ProjectlistKey;

public interface ProjectlistMapper {
    int countByExample(ProjectlistExample example);

    int deleteByExample(ProjectlistExample example);

    int deleteByPrimaryKey(ProjectlistKey key);

    int insert(Projectlist record);

    int insertSelective(Projectlist record);

    List<Projectlist> selectByExample(ProjectlistExample example);

    Projectlist selectByPrimaryKey(ProjectlistKey key);

    int updateByExampleSelective(@Param("record") Projectlist record, @Param("example") ProjectlistExample example);

    int updateByExample(@Param("record") Projectlist record, @Param("example") ProjectlistExample example);

    int updateByPrimaryKeySelective(Projectlist record);

    int updateByPrimaryKey(Projectlist record);
}