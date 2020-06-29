package mainpro;

import java.util.ArrayList;





public class Result{
	Sub_dater sub_dater;
	Day_dater day_dater;
	ArrayList<ArrayList<ArrayList<Sub_dater>>> list_base_base ;
	ArrayList<ArrayList<ArrayList<Sub_dater>>> list_re ;
		ArrayList<ArrayList<Sub_dater>> list_base ;
		ArrayList<Sub_dater> sub;
	ArrayList<ArrayList<Sub_dater>> list = new ArrayList<>();
    //static boolean visit[] = new boolean[arr.length];
	ArrayList<Sub_dater> vi;
	public Result(ArrayList<ArrayList<Sub_dater>> A, ArrayList<ArrayList<Sub_dater>> B) {

list_base = new ArrayList<>();
				
		
		// 리스트에 과목박스들 담기
		 for(int v=0; v<A.size();v++) {
    		 list.add(A.get(v));
    	 }
		 //
		 
			// 리스트에 과목박스들 담기
		 for(int v=0; v<B.size();v++) {
    		 list.add(B.get(v));
    	 }
		 //

		 
		 // 조합 구하기
		Combination_Result c = new Combination_Result(list);
        c.doCombination(list.size(), 2, 0);
		// 

        
		list_base_base=c.list;
		

		
		
        /* 조합 결과 받기
        for(int v=0; v<c.list.size();v++) {
        list_base_base.add(c.list.get(v));
        }
        */
        
for(int i=list_base_base.size()-1 ; i>=0; i--) {

	int check=0;
	for(int y=0; y<A.size();y++) {
		if(list_base_base.get(i).get(0).equals(A.get(y))) {
			for(int h=0 ; h<A.size() ; h++) {
				if(list_base_base.get(i).get(1).equals(A.get(h))) {
			list_base_base.remove(i);
			check=1;

			break;
				}
			}
		}
		if(check==1) { 
			break;
		}
	}
}
	
for(int i=list_base_base.size()-1 ; i>=0; i--) {
int check = 0;
	
	for(int u=0 ; u<B.size() ; u++) {
		if(list_base_base.get(i).get(0).equals(B.get(u))) {
			for(int h=0 ; h<B.size() ; h++) {
				if(list_base_base.get(i).get(1).equals(B.get(h))) {
			list_base_base.remove(i);
			check=1;

			break;
				}
			}
		}
		if(check==1) { 
			break;
		}
	}
	check=0;
}
        
for(int t=0; t<list_base_base.size();t++) {
	sub = new ArrayList<>();
for(int h=0; h<list_base_base.get(t).get(0).size() ;h++) {
	sub.add(list_base_base.get(t).get(0).get(h));
}
for(int h=0; h<list_base_base.get(t).get(1).size(); h++) {
	sub.add(list_base_base.get(t).get(1).get(h));
}
list_base.add(sub);
}



Same_Time();
        
        
      

      //  Same_Time(); // 시간이 겹치는 과목
  
        
	}
	

	
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
	
	
}
