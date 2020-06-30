package mainpro;

import java.util.ArrayList;





public class Result_process_select {
	Sub_dater sub_dater;
	Day_dater day_dater;
		ArrayList<ArrayList<Sub_dater>> list_base ;
	ArrayList<Sub_dater> list = new ArrayList<>();
	int sub_grade=0;
	ArrayList<Sub_dater> information;
    //static boolean visit[] = new boolean[arr.length];
	ArrayList<Sub_dater> vi;
	public Result_process_select(ArrayList<Sub_dater> A, Day_dater B, int sub_g) {
sub_grade = sub_g;
list_base = new ArrayList<>();
		day_dater = new Day_dater();
		day_dater = B;

		information = new ArrayList<>();
		int check=0;

		// 중복없는 목록 과목 담기, 필수 학점 계산
		for(int i=0;i<A.size();i++) {
			for(int v=0;v<information.size();v++) {
				if(information.get(v).subject_name.equals(A.get(i).subject_name)) {
					check=1;
				}
		}
			if(check!=1) {
			information.add(A.get(i));
			}
			check=0;
		}
		//


		// 리스트에 과목박스들 담기
		 for(int v=0; v<A.size();v++) {
    		 list.add(A.get(v));
    	 }
		 //



		 // 조합 구하기
		 for(int c_c=1; c_c<=information.size() ; c_c++) {
		Combination c = new Combination(list);
        c.doCombination(list.size(), c_c, 0);

		//

        // 조합 결과 받기
        for(int v=0; v<c.list.size();v++) {
        list_base.add(c.list.get(v));
        }
        //
		 }




        Holiday();  // 공강시간대
        score(); // 과목 학점 일치
        Same(); // 중복되어 있는 과목
        Same_Time(); // 시간이 겹치는 과목
        //Sub_Check(); // 과목 존재여부




       /*
        // 플레이 예시
        for(int v=0; v<list_base.size();v++) {
        	vi = new ArrayList<>();
        	for(int b=0; b<list_base.get(v).size();b++) {
        	vi.add(list_base.get(v).get(b));

        	}

        	for(int b=0; b<list_base.get(v).size();b++) {
           	 Sub_dater hh = new Sub_dater();
           	 hh=vi.get(b);
        		System.out.println(hh.subject_name);

            	}

        	System.out.println("--------------------");
        }
        //
        */
       	System.out.println("선택");


	}


	// 과목 전부 존재 체크
	public void Sub_Check() {
		 ArrayList<String> member; // member는 과목의 조합
		 int check_zone=0;
		 	       for(int v=list_base.size()-1; v>=0;v--) {
		 	       	member = new ArrayList<>();
		 	       	for(int b=0; b<list_base.get(v).size();b++) {
		 	       	member.add((list_base.get(v).get(b).subject_name));
		 	       	}

		 	      for(int tv=0; tv<information.size();tv++) {
		 	    	  for(int tt=0; tt<member.size();tt++) {
		 	    		  if(member.get(tt).equals(information.get(tv).subject_name)) {
		 	    			  check_zone=1;
		 	    		  }

		 	    	  }
		 	    	 if(check_zone!=1) {
	 	    			  check_zone=0;
	 	    			  list_base.remove(v);
	 	    			  break;
	 	    		  }
		 	    	 check_zone=0;
		 	      }

		 		}
	}
	//

	// 중복시간 체크
	public void Same_Time() {
	   	 ArrayList<Sub_dater> member; // member는 과목의 조합
int check_same=0;
	       for(int v=list_base.size()-1; v>=0;v--) {
	       	member = new ArrayList<>();
	       	for(int b=0; b<list_base.get(v).size();b++) {
	       	member.add((list_base.get(v).get(b)));
	       	}

	       	for(int b=0; b<member.size();b++) {
	       		if((b+1)!=member.size()) {
	       		for(int t=b+1; t<member.size();t++) {
if(member.get(b).Day_first.equals(member.get(t).Day_first)) {
	if(member.get(b).Date_first_1.equals(member.get(t).Date_first_1)) {
		if(!member.get(b).Date_first_1.equals("")&&!member.get(t).Date_first_1.equals("")) {
		list_base.remove(v);
		check_same=1;
		break;
		}
	}
    if(member.get(b).Date_first_1.equals(member.get(t).Date_first_2)) {
		if(!member.get(b).Date_first_1.equals("")&&!member.get(t).Date_first_2.equals("")) {
		list_base.remove(v);
		check_same=1;
		break;
		}
	}
    if(member.get(b).Date_first_1.equals(member.get(t).Date_first_3)) {
		if(!member.get(b).Date_first_1.equals("")&&!member.get(t).Date_first_3.equals("")) {
		list_base.remove(v);
		check_same=1;
		break;
		}
    }
    if(member.get(b).Date_first_2.equals(member.get(t).Date_first_1)) {
		if(!member.get(b).Date_first_2.equals("")&&!member.get(t).Date_first_1.equals("")) {
		list_base.remove(v);
		check_same=1;
		break;
		}
    }
    if(member.get(b).Date_first_2.equals(member.get(t).Date_first_2)) {
		if(!member.get(b).Date_first_2.equals("")&&!member.get(t).Date_first_2.equals("")) {
		list_base.remove(v);
		check_same=1;
		break;
		}
    }
    if(member.get(b).Date_first_2.equals(member.get(t).Date_first_3)) {
		if(!member.get(b).Date_first_2.equals("")&&!member.get(t).Date_first_3.equals("")) {
		list_base.remove(v);
		check_same=1;
		break;
		}
    }
    if(member.get(b).Date_first_3.equals(member.get(t).Date_first_1)) {
		if(!member.get(b).Date_first_3.equals("")&&!member.get(t).Date_first_1.equals("")) {
		list_base.remove(v);
		check_same=1;
		break;
		}
    }
    if(member.get(b).Date_first_3.equals(member.get(t).Date_first_2)) {
		if(!member.get(b).Date_first_3.equals("")&&!member.get(t).Date_first_2.equals("")) {
		list_base.remove(v);
		check_same=1;
		break;
		}
    }
    if(member.get(b).Date_first_3.equals(member.get(t).Date_first_3)) {
		if(!member.get(b).Date_first_3.equals("")&&!member.get(t).Date_first_3.equals("")) {
		list_base.remove(v);
		check_same=1;
		break;
		}
    }
}
if(member.get(b).Day_first.equals(member.get(t).Day_Second)) {
	if(member.get(b).Date_first_1.equals(member.get(t).Date_Second_1)) {
		if(!member.get(b).Date_first_1.equals("")&&!member.get(t).Date_Second_1.equals("")) {
		list_base.remove(v);
		check_same=1;
		break;
		}
	}
    if(member.get(b).Date_first_1.equals(member.get(t).Date_Second_2)) {
		if(!member.get(b).Date_first_1.equals("")&&!member.get(t).Date_Second_2.equals("")) {
		list_base.remove(v);
		check_same=1;
		break;
		}
	}
    if(member.get(b).Date_first_1.equals(member.get(t).Date_Second_3)) {
		if(!member.get(b).Date_first_1.equals("")&&!member.get(t).Date_Second_3.equals("")) {
		list_base.remove(v);
		check_same=1;
		break;
		}
    }
    if(member.get(b).Date_first_2.equals(member.get(t).Date_Second_1)) {
		if(!member.get(b).Date_first_2.equals("")&&!member.get(t).Date_Second_1.equals("")) {
		list_base.remove(v);
		check_same=1;
		break;
		}
    }
    if(member.get(b).Date_first_2.equals(member.get(t).Date_Second_2)) {
		if(!member.get(b).Date_first_2.equals("")&&!member.get(t).Date_Second_2.equals("")) {
		list_base.remove(v);
		check_same=1;
		break;
		}
    }
    if(member.get(b).Date_first_2.equals(member.get(t).Date_Second_3)) {
		if(!member.get(b).Date_first_2.equals("")&&!member.get(t).Date_Second_3.equals("")) {
		list_base.remove(v);
		check_same=1;
		break;
    }
    }
    if(member.get(b).Date_first_3.equals(member.get(t).Date_Second_1)) {
		if(!member.get(b).Date_first_3.equals("")&&!member.get(t).Date_Second_1.equals("")) {
		list_base.remove(v);
		check_same=1;
		break;
		}
    }
    if(member.get(b).Date_first_3.equals(member.get(t).Date_Second_2)) {
		if(!member.get(b).Date_first_3.equals("")&&!member.get(t).Date_Second_2.equals("")) {
		list_base.remove(v);
		check_same=1;
		break;
		}
    }
    if(member.get(b).Date_first_3.equals(member.get(t).Date_Second_3)) {
		if(!member.get(b).Date_first_3.equals("")&&!member.get(t).Date_Second_3.equals("")) {
		list_base.remove(v);
		check_same=1;
		break;
		}
    }
}
if(member.get(b).Day_Second.equals(member.get(t).Day_first)) {
	if(member.get(b).Date_Second_1.equals(member.get(t).Date_first_1)) {
		if(!member.get(b).Date_Second_1.equals("")&&!member.get(t).Date_first_1.equals("")) {
		list_base.remove(v);
		check_same=1;
		break;
		}
	}
    if(member.get(b).Date_Second_1.equals(member.get(t).Date_first_2)) {
    	if(!member.get(b).Date_Second_1.equals("")&&!member.get(t).Date_first_2.equals("")) {
		list_base.remove(v);
		check_same=1;
		break;
    	}
	}
    if(member.get(b).Date_Second_1.equals(member.get(t).Date_first_3)) {
    	if(!member.get(b).Date_Second_1.equals("")&&!member.get(t).Date_first_3.equals("")) {
		list_base.remove(v);
		check_same=1;
		break;
    	}
    }
    if(member.get(b).Date_Second_2.equals(member.get(t).Date_first_1)) {
    	if(!member.get(b).Date_Second_2.equals("")&&!member.get(t).Date_first_1.equals("")) {
		list_base.remove(v);
		check_same=1;
		break;
    	}
    }
    if(member.get(b).Date_Second_2.equals(member.get(t).Date_first_2)) {
    	if(!member.get(b).Date_Second_2.equals("")&&!member.get(t).Date_first_2.equals("")) {
		list_base.remove(v);
		check_same=1;
		break;
    	}
    }
    if(member.get(b).Date_Second_2.equals(member.get(t).Date_first_3)) {
    	if(!member.get(b).Date_Second_2.equals("")&&!member.get(t).Date_first_3.equals("")) {
		list_base.remove(v);
		check_same=1;
		break;
    	}
    }
    if(member.get(b).Date_Second_3.equals(member.get(t).Date_first_1)) {
    	if(!member.get(b).Date_Second_3.equals("")&&!member.get(t).Date_first_1.equals("")) {
		list_base.remove(v);
		check_same=1;
		break;
    	}
    }
    if(member.get(b).Date_Second_3.equals(member.get(t).Date_first_2)) {
    	if(!member.get(b).Date_Second_3.equals("")&&!member.get(t).Date_first_2.equals("")) {
		list_base.remove(v);
		check_same=1;
		break;
    	}
    }
    if(member.get(b).Date_Second_3.equals(member.get(t).Date_first_3)) {
    	if(!member.get(b).Date_Second_3.equals("")&&!member.get(t).Date_first_3.equals("")) {
		list_base.remove(v);
		check_same=1;
		break;
    	}
    }
}
if(member.get(b).Day_Second.equals(member.get(t).Day_Second)) {
	if(!member.get(b).Day_Second.equals("")&&!member.get(t).Day_Second.equals("")) {
	if(member.get(b).Date_Second_1.equals(member.get(t).Date_Second_1)) {
		if(!member.get(b).Date_Second_1.equals("")&&!member.get(t).Date_Second_1.equals("")) {
		list_base.remove(v);
		check_same=1;
		break;
		}
	}
    if(member.get(b).Date_Second_1.equals(member.get(t).Date_Second_2)) {
    	if(!member.get(b).Date_Second_1.equals("")&&!member.get(t).Date_Second_2.equals("")) {
		list_base.remove(v);
		check_same=1;
		break;
    	}
	}
    if(member.get(b).Date_Second_1.equals(member.get(t).Date_Second_3)) {
    	if(!member.get(b).Date_Second_1.equals("")&&!member.get(t).Date_Second_3.equals("")) {
		list_base.remove(v);
		check_same=1;
		break;
    	}
    }
    if(member.get(b).Date_Second_2.equals(member.get(t).Date_Second_1)) {
    	if(!member.get(b).Date_Second_2.equals("")&&!member.get(t).Date_Second_1.equals("")) {
		list_base.remove(v);
		check_same=1;
		break;
    	}
    }
    if(member.get(b).Date_Second_2.equals(member.get(t).Date_Second_2)) {
    	if(!member.get(b).Date_Second_2.equals("")&&!member.get(t).Date_Second_2.equals("")) {
		list_base.remove(v);
		check_same=1;
		break;
    	}
    }
    if(member.get(b).Date_Second_2.equals(member.get(t).Date_Second_3)) {
    	if(!member.get(b).Date_Second_2.equals("")&&!member.get(t).Date_Second_3.equals("")) {
		list_base.remove(v);
		check_same=1;
		break;
    	}
    }
    if(member.get(b).Date_Second_3.equals(member.get(t).Date_Second_1)) {
    	if(!member.get(b).Date_Second_3.equals("")&&!member.get(t).Date_Second_1.equals("")) {
		list_base.remove(v);
		check_same=1;
		break;
    	}
    }
    if(member.get(b).Date_Second_3.equals(member.get(t).Date_Second_2)) {
    	if(!member.get(b).Date_Second_3.equals("")&&!member.get(t).Date_Second_2.equals("")) {
		list_base.remove(v);
		check_same=1;
		break;
    	}
    }
    if(member.get(b).Date_Second_3.equals(member.get(t).Date_Second_3)) {
    	if(!member.get(b).Date_Second_3.equals("")&&!member.get(t).Date_Second_3.equals("")) {
		list_base.remove(v);
		check_same=1;
		break;
    	}
    }
	}
}
	       		}


	       		}
	       		if(check_same==1) {
	       			check_same=0;
	       			break;
	       		}
		       	}
		}
		}
	//

	// 중복과목 체크
	public void Same() {
	   	 ArrayList<String> member; // member는 과목의 조합
int check_sub=0;
	       for(int v=list_base.size()-1; v>=0;v--) {
	       	member = new ArrayList<>();
	       	for(int b=0; b<list_base.get(v).size();b++) {
	       	member.add((list_base.get(v).get(b).subject_name));
	       	}

	       	for(int b=0; b<list_base.get(v).size();b++) {
	       		if((b+1)!=list_base.get(v).size()) {
	       		for(int t=b+1; t<list_base.get(v).size();t++) {
if(member.get(b).equals(member.get(t))) {
	list_base.remove(v);
	check_sub=1;
	break;
}
	       		}
	       		}
	       		if(check_sub==1) {
	       			check_sub=0;
	       			break;
	       		}
		       	}
		}
		}
	//

	// 학점체크
	public void score() {
	   	 ArrayList<Integer> member; // member는 과목의 조합

	       for(int v=list_base.size()-1; v>=0;v--) {
	   	   	int check=0;
	       	member = new ArrayList<>();
	       	for(int b=0; b<list_base.get(v).size();b++) {
	       	member.add(Integer.valueOf(list_base.get(v).get(b).Sub_num));
	       	}

	       	for(int b=0; b<list_base.get(v).size();b++) {
		       	check+=member.get(b);
		       	}
	    if(check!=sub_grade) {
	    	list_base.remove(v);
	    }
		}
		}
	//

    // 공강체크
    public void Holiday() { //list는 과목의 조합을 품은 조합
    	 ArrayList<Sub_dater> member; // member는 과목의 조합
        for(int v=list_base.size()-1; v>=0;v--) {
        	member = new ArrayList<>();
        	for(int b=0; b<list_base.get(v).size();b++) {
        	member.add(list_base.get(v).get(b));
        	}



        	for(int b=0; b<list_base.get(v).size();b++) {

           	 Sub_dater hh = new Sub_dater(); //과목
           	 hh=member.get(b);

           	 if(day_dater.monday == true) {

           		 if (hh.Day_first.equals("월")||hh.Day_Second.equals("월")) {

           			 list_base.remove(v);
           			 break;
           		 }
           	 }
           	 if(day_dater.tuesday == true) {
           		 if (hh.Day_first.equals("화")||hh.Day_Second.equals("화")) {
           			 list_base.remove(v);
           			 break;
           		 }
           	 }
           	 if(day_dater.wednesday == true) {
           		 if (hh.Day_first.equals("수")||hh.Day_Second.equals("수")) {
           			 list_base.remove(v);
           			 break;
           		 }
	 }
           	 if(day_dater.thursday == true) {
           		 if (hh.Day_first.equals("목")||hh.Day_Second.equals("목")) {
           			 list_base.remove(v);
           			 break;
           		 }
	 }
           	 if(day_dater.friday == true) {
           		 if (hh.Day_first.equals("금")||hh.Day_Second.equals("금")) {
           			 list_base.remove(v);
           			 break;
           		 }
	 }
        	}
        } // 여기까지가 전체


    }
 // 여기까지가 공강 체크

}
