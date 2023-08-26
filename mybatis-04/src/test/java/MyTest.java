import com.kuang.Utils.IDutils;
import com.kuang.Utils.MybatisUtils;
import com.kuang.pojo.Blog;
import dao.BlogMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class MyTest {
    @Test
    public void addInitBlog(){
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDutils.getId());
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("冷丁");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("Java如此简单");
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("Spring如此简单");
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("微服务如此简单");
        mapper.addBlog(blog);

        session.close();
    }


    @Test
    public void queryBlogIF(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        map.put("title","Mybatis如此简单");
        List<Blog> blogs = mapper.queryBlogIF(map);

        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }


    @Test
    public  void hash() {

        HashMap<String, Integer> map = new HashMap<>();
        map.put("Tom",18);//保存key与value的值
        map.put("Jack",19);
        int age = map.getOrDefault("Tom",-12);
        int age2 = map.get("Jack");//得到其对应的哈希映射
        System.out.println(age);
        System.out.println(age2);
        System.out.println(map.containsKey("Tom"));//判断是否有键值，返回的是true或false的布尔值
        System.out.println("================================");

        for (Map.Entry<String,Integer>entry:map.entrySet()){//遍历哈希表
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("key: "+key);
            System.out.println("value: "+value);
        }

    }

    public static void main(String[] args) {

        int[] nums = new int[]{2,3,7,8};
        for (int num : nums){
            System.out.println(num);
        }


        /*int n = nums.length,index=0;
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]%2==0){
                res[index++]=nums[i];
            }
        }*/

        int n = nums.length,index=0;
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]%2==1){
                res[index++]=nums[i];
            }
        }
        System.out.println(res);

    }

    @Test
    public void leecode(){
        int nums[] = new int[]{2,3,1,4,0};
        int n = nums.length;
        for (int i = 0, j = 0; i < n; i++) {
            if (nums[i]%2== 0) {
                int tem = nums[i];
                nums[i] = nums[j];
                nums[j] = tem;
                j ++;
            }
        }
        System.out.println(Arrays.toString(nums));//把数组输出出来，也可以用 ”字符串.toCharArray()“来获取字符串或数组的数据
        System.out.println(3&1);//奇数判断为1
        System.out.println(4&1);//偶数判断为0


    }

}
