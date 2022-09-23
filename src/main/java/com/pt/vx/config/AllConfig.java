package com.pt.vx.config;
import java.time.LocalDate;

import com.pt.vx.domain.BirthDay;
import com.pt.vx.domain.User;

import java.util.ArrayList;
import java.util.List;
/**
 * 内置的模板有：
 * 在微信模板里添加{{xxx.DATA}}
 *
 * 个人信息相关：
 * userName 昵称
 * holdDay 距离某天的天数
 * yourBirthDay 生日
 * myBirthDay 对象生日
 * loveDay 纪念日倒计时
 *
 * 天气相关：
 * date 日期
 * week 星期
 * weatherDay（1，2，3，4） 白天天气
 * temperatureDay（1，2，3，4）白天温度
 * windDay（1，2，3，4）白天风向
 * powerDay（1，2，3，4）白天风力
 * weatherNight（1，2，3，4） 晚上天气
 * temperatureNight（1，2，3，4） 晚上温度
 * windNight（1，2，3，4） 晚上风向
 * powerNight（1，2，3，4） 晚上风力
 * weatherNow 现在天气
 * temperatureNow 现在温度
 * windNow 现在风向
 * powerNow 现在风力
 * humidityNow 现在湿度
 *
 * 其他：
 * otherInfo 额外提示
 * randomRead 精彩短句
 * worldRead 世界新闻
 * tianGou 舔狗日记
 * qingHua 情话
 * english 励志英语
 * historyToday 历史的今天
 * horoscope 星座解析
 * randomInfo 随机额外类型消息
 * wozairenjian 我在人间凑日子散文
 * miyu 谜语
 * poetry 诗句
 * dongman 动漫
 * story 小说
 */
public class AllConfig {
    public static final String VxAppId = "wx5d327b5689067daf";
    public static final String VxAppSecret = "1628b6ed67a69e5cacebf9e7bead2ff8";
    public static final String WeatherKey = "1601cf295c588b05978282d98657f5eb";

    //基本类型消息
    public static final boolean open_info = true; //是否开启个人情况 true 为开启， false 为不开启
    public static final boolean open_weather = true; //是否开启天气预报
    public static final boolean open_other_info= true; //是否开启额外信息（需要开启日期和天气预报）

    //额外类型消息
    public static final boolean open_history_today = true; //是否开启历史上的今天
    public static final boolean open_qinghua = true; //是否开启情话一句
    public static final boolean open_dongman = true; //是否开启动漫台词
    public static final boolean open_tiangou = true; //是否开启舔狗日记
    public static final boolean open_world_read = true; //是否开启世界新闻
    public static final boolean open_random_read = true; //是否开启随机短句
    public static final boolean open_wozairenjian = true; //是否开启散文集我在人间凑日子
    public static final boolean open_poetry = true; //是否开启随机诗句
    public static final boolean open_english = true; //是否开启每日英语
    public static final boolean open_miyu = true; //是否开启谜语
    public static final boolean open_horoscope= true; //是否开启星座解析
    public static final boolean random_module = true; //随机一个开启了的额外类型消息

    //小说
    public static final boolean open_story = false; //开启小说,每天推送一章(最新发现微信对太长的内容会截断，所以小说可以忽略了）
    public static final String title = "小说名称"; //小说名称
    public static final String author = "小说作者"; //小说作者
    public static final LocalDate start_time = LocalDate.of(2022,9,22);//第一次运行程序的时间，用来推断小说要看到第几章了



    private static void init(){
        //如果要多个人的话，就复制这个一遍，然后填写里面的内容。这里默认两个人,大伙应该是两个人吧（笑）
        userList.add(getUser(
                "1601cf295c588b05978282d98657f5eb",//扫码关注你的测试号以后，测试平台会出现TA的微信号
                "小宝",//咋称呼这个人
                new BirthDay(2003,3,11,false),  //这个人的生日，最后的这个true/false，如果是过公历生日就写false，如果是过农历生日写true
                new BirthDay(2003,9,29,true), //这个人对象的生日，最后的这个true/false，如果是过公历生日就写false，如果是过农历生日写true
                LocalDate.of(2022,9,15),//这个人的纪念日起点，比如说在一起的那一天
                "陕西省咸阳市",//这个人的详细地址
                "咸阳",//这个人在的城市
                "HZ-nNKe1SROy4xeqL9ZUP1rpBNOV4ZMNFHYr_7gVwyU"));//要给这个人发送的模板ID

        userList.add(getUser(
                "oldhc5rAv58jnAHsqYzEUXNfRxv4",
                "小宝",
                new BirthDay(2003,3,11,true),  //这个人的生日，最后的这个true/false，如果是过公历生日就写false，如果是过农历生日写true
                new BirthDay(2004,4,11,false), //这个人对象的生日，最后的这个true/false，如果是过公历生日就写false，如果是过农历生日写true
                LocalDate.of(2022,6,9),//这个人的纪念日
                "北京市朝阳区",//这个人的详细地址
                "北京",//这个人在的城市
                "HZ-nNKe1SROy4xeqL9ZUP1rpBNOV4ZMNFHYr_7gVwyU"));//要给这个人发送的模板ID

        
    }

    public static final List<User> userList = new ArrayList<>();
    static {
        init();
    }


    private static User getUser(String Vx, String username,
                                BirthDay birthday,
                                BirthDay careDay,
                                LocalDate loveDay,
                                String address, String city, String templateId){
        User user=new User();
        user.setVx(Vx);
        user.setUserName(username);
        user.setCareDay(careDay);
        user.setBirthDay(birthday);
        user.setLoveDay(loveDay);
        user.setAddress(address);
        user.setCity(city);
        user.setTemplateId(templateId);
        return user;
    }



}
