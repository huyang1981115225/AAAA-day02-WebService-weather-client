package cn.com.client;

import java.util.List;
import java.util.Scanner;

import cn.com.webxml.ArrayOfString;
import cn.com.webxml.WeatherWS;
import cn.com.webxml.WeatherWSSoap;
/**
 * 编写天气预报查询系统WebService
 * 
 * @author HY
 *
 */
public class ClientTest {
	public static void main(String[] args) {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("欢迎进入天气预报查询系统");
			System.out.println("请输入需要查询的城市...");
			String city = scanner.nextLine();
			if (!"exit".equals(city.toLowerCase())) {
				
				WeatherWS weatherWS = new WeatherWS();
				
				WeatherWSSoap weatherWSSoap = weatherWS.getWeatherWSSoap();
				
				ArrayOfString weather = weatherWSSoap.getWeather(city, null);
				
				List<String> list = weather.getString();
				System.out.println(list);
				System.out.println();
			}else {
				System.out.println("谢谢使用天气查询系统，Bye~");
				break;
			}
		}
	}
}
