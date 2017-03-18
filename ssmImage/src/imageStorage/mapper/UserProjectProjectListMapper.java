package imageStorage.mapper;

import java.util.List;

import imageStorage.entity.FindUserVo;
import imageStorage.entity.ShowData;

/**
 *<p>Title:UserProjectProjectListMapper.java</p>
 *<p>Description:根据传入的体检项目名称，得到体检客户的信息</p>
 * @author guihongli
 * @date 2017年3月15日
 */
public interface UserProjectProjectListMapper {
	public List<ShowData> findUserByProjectName(FindUserVo findUserVo)throws Exception;
	public int findUserCountByProjectName(FindUserVo findUserVo)throws Exception;
}
