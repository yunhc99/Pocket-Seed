package mainpro;

import java.util.ArrayList;
import java.util.StringTokenizer;


public class Sub_dater {
String subject_name="";
String Day_first="";
String Date_first_1="";
String Date_first_2="";
String Date_first_3="";
String Day_Second="";
String Date_Second_1="";
String Date_Second_2="";
String Date_Second_3="";
String Sub_num="";
String Sub_human="";
String origin_sub_dater="";


ArrayList<String> list = new ArrayList<>();
int count = 0;

int sub_check; // 학점 체크
int hum_check; // 인원 체크
int day1; //첫번째 요일 체크
int day2; //두번째 요일 체크

public Sub_dater(String origin_sub_dater){
	this.origin_sub_dater = origin_sub_dater;
	StringTokenizer sub_dater = new StringTokenizer(origin_sub_dater);
	while(sub_dater.hasMoreTokens()) {
	  list.add(sub_dater.nextToken(" ,/  "));
	}


	for(int v=0; v<list.size(); v++) { // 해당 문자열 지점 찾기
		if (list.get(v).equals("월")||list.get(v).equals("화")||list.get(v).equals("수")||list.get(v).equals("목")
				||list.get(v).equals("금")) {

			count++;

			if (count==1) {
				day1 = v;
			}
			else if(count==2) {
				day2 = v;
			}
		}
		if(list.get(v).equals("학점:")) {
			sub_check=v;
		}
		if(list.get(v).equals("인원:")) {
			hum_check=v;
		}
	}

	if(count==1) { // 시간이 하나일 경우
		int i=1;
		subject_name=list.get(0);
		while(i!=sub_check) { // 학점까지 끊기
		if(i==1) {
			Day_first=list.get(i);
		}
		else if(i==2) {
			Date_first_1=list.get(i);
		}
		else if(i==3) {
			Date_first_2=list.get(i);
		}
		else if(i==4) {
			Date_first_3=list.get(i);
		}
		i++;
		}
		Sub_num = list.get(sub_check+1);
		Sub_human = list.get(hum_check+1);
	}
	else if(count==2) { // 시간이 두개일 경우
		int i=1;
		subject_name=list.get(0);
		while(i!=day2) { // 두번째 요일까지 끊기
		if(i==1) {
			Day_first=list.get(i);
		}
		else if(i==2) {
			Date_first_1=list.get(i);
		}
		else if(i==3) {
			Date_first_2=list.get(i);
		}
		else if(i==4) {
			Date_first_3=list.get(i);
		}
		i++;
		}

		while(i!=sub_check) { // 학점까지 끊기
			if(i==day2) {
				Day_Second=list.get(i);
			}
			else if(i==day2+1) {
				Date_Second_1=list.get(i);
			}
			else if(i==day2+2) {
				Date_Second_2=list.get(i);
			}
			else if(i==day2+3) {
				Date_Second_3=list.get(i);
			}
			i++;
			}
		Sub_num = list.get(sub_check+1);
		Sub_human = list.get(hum_check+1);
	}
}

}
