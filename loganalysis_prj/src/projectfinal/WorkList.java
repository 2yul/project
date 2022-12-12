package projectfinal;


import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * 수행해야 하는 일들을 모아둔 클래스
 * @author user
 *
 */
public class WorkList {
	//필드
	private List<String[]> arrayList;
	private List<String> keyList; 

	public static final int RESULT = 0;
	public static final int REQUEST = 1;
	public static final int BROWSER = 2;
	public static final int DAY_TIME = 3;
	
	//불러온 데이터를 List로 저장하는 코드
	private void makeArrayList(String file) throws IOException {
		BufferedReader br = null;
		arrayList = new ArrayList<>();
		String readData = null;
		StringTokenizer st = null;
		String[] data = null;
		int i = 0;
		try {
			br = new BufferedReader(new FileReader(file));
			//불러온 데이터의 내용을 반복문을 사용하여 저장해 준다.
			while ((readData = br.readLine()) != null) {
				//StringTokenizer를 사용하여 [ ]를 기준으로 잘라내어 준다.
				st = new StringTokenizer(readData, "[]");
				data = new String[st.countTokens()];
				while(st.hasMoreTokens()) {
					data[i] = st.nextToken();
					++i;
				}
				arrayList.add(data);
				i=0;
			}
		} finally {
			if(br!=null) {br.close();}
		}
	}
	
	//1번 문제를 풀기 위한 KeyList
	private void makeKeyListData(String file) throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String readData = null;
			keyList = new ArrayList<>();
			//불러온 데이터를 반복문을 사용하여 KeyList에 저장해 준다.
			while ((readData = br.readLine()) != null) {
				//Key 문자열을  찾아 잘라내어 저장한다.
				if(readData.contains("key")) {
					keyList.add(readData.substring(readData.indexOf("=") + 1, readData.lastIndexOf("&")));
				} else {
					keyList.add("ErrorData");
				}
			}
		} finally {
			if(br!=null) {br.close();}
		}
	}
	
	public String work1(String file) throws IOException {
		String result = "";
		makeKeyListData(file);
		Map<String, Integer> map = new TreeMap<>();
		String[] keyArray  = new String[keyList.size()];
		int count=0;
		for(int i=0; i<keyList.size(); i++) {
			keyArray[i]=keyList.get(i);
			 if(map.containsKey(keyArray[i])) {
				 count=map.get(keyArray[i]);
				 map.put(keyArray[i], count+1);
			 }else {
				 map.put(keyArray[i],1);
			 }//end else
		}//end for
		
		Entry<String, Integer> maxKey = Collections.max(map.entrySet(),Map.Entry.comparingByValue());
		result = "가장 많은 키 : [" + maxKey.getKey() + "]" + ", 횟수 : " + maxKey.getValue();
		//출력검증
		return result;
	}
	
	public String work2(String file) throws IOException {
		makeArrayList(file);
		Map<String, Integer> browserMap;
		String[] webArray = new String[arrayList.size()];
		browserMap = new HashMap<>();
		int count = 0;
		for(int i = 0 ; i < arrayList.size(); i ++) {
			webArray[i] = arrayList.get(i)[BROWSER];
			if(browserMap.containsKey(webArray[i])) {
				count = browserMap.get(webArray[i]);
				browserMap.put(webArray[i], count + 1);
			} else {
				browserMap.put(webArray[i], 1);
			}
		}
		Set<String> webSet = browserMap.keySet();
		StringBuffer sb = new StringBuffer();
		double percentage = 0;
		int temp = 0;
		for(String key : webSet) {
			percentage = browserMap.get(key)/(double)arrayList.size()*100; 
			temp = (int)(percentage*100);
			percentage = temp/100.0;
			sb.append(key).append(" : ").append(browserMap.get(key)).append("회").
				append("(").append(percentage).append("%)").append("").append("\n");
		}
		//출력검증
//		System.out.print(sb.toString());
		return sb.toString();
	}
	
	public String work3(String file) throws IOException {
		String result = "";
		makeArrayList(file);
		int successCount = 0 ;
		int failCount = 0;
		for(int i = 0; i < arrayList.size(); i ++) {
			switch(arrayList.get(i)[RESULT]) {
			case "200": ++successCount; break;
			case "404": ++failCount; break;
			}
		}
		result = "성공적으로 실행한 횟수[200] = " + successCount +" 회"+"\n"+"실패한 횟수[404] = " + failCount + "회";
		//출력검증
//		System.out.println(result);
		return result;
	}
	
	public String work4(String file) throws IOException {
		String result = "";
		makeArrayList(file);
		Map<String, Integer> timeMap = new TreeMap<>();
		String[] timeArray =  new String[arrayList.size()]; 
		int count = 0;
		for(int i = 0; i  < arrayList.size() ; i ++) {
			timeArray[i] = arrayList.get(i)[DAY_TIME].substring(11,13);
			if(timeMap.containsKey(timeArray[i])) {
				count = timeMap.get(timeArray[i]);
				timeMap.put(timeArray[i], count +1);
			} else {
				timeMap.put(timeArray[i], 1);
			}
		}
		
		Entry<String, Integer> maxTime = Collections.max(timeMap.entrySet(),Map.Entry.comparingByValue());
		result = "가장 많은 접속시간 : [" + maxTime.getKey() + "시]" + ", 횟수 : " + maxTime.getValue();
		//출력검증
//		System.out.println(result);
		return result;
	}
	
	public String work5And6(String file, String requestResult) throws IOException {
		String result = "";
		makeArrayList(file);
		int count = 0;
		for(int i = 0; i < arrayList.size(); i ++) {
			count = arrayList.get(i)[RESULT].equals(requestResult) ? ++count : count;
		}
		double percentage = count / (double)arrayList.size()*100;
		int temp = (int)(percentage*100);
		percentage = temp/100.0;
		result = "[" + requestResult + "]" + "의 횟수 : " +count + ", 비율 : " + percentage + "%";
		//출력검증
//		System.out.println(result);
		return result;
	}
	
	
	public String work7(String file, int startLine, int endLine) throws IOException, IndexOutOfBoundsException {
		String result = "";
		makeKeyListData(file);
		Map<String, Integer> map = new TreeMap<>();
		String[] keyArray = new String[keyList.size()];
		int count=0;
		for(int i=startLine-1; i<endLine; i++) {
			keyArray[i]=keyList.get(i);
			 if(map.containsKey(keyArray[i])) {
				 count=map.get(keyArray[i]);
				 map.put(keyArray[i], count+1);
			 }else {
				 map.put(keyArray[i],1);
			 }//end else
		}//end for
		
		Entry<String, Integer> maxKey = Collections.max(map.entrySet(),Map.Entry.comparingByValue());
		result = startLine + " 라인부터 " + endLine +" 라인까지 가장 많은 키 : [" + maxKey.getKey() + "]"+ "\n" + "횟수 : " + maxKey.getValue();
		//츨력검증
//		System.out.println(result);
		return result;
		
	}

}
