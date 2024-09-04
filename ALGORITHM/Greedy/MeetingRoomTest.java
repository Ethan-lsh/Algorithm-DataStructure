package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MeetingRoomTest {

	static class Meeting implements Comparable<Meeting>{
		
		private int start;
		private int end;

		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Meeting o) {
			return this.end != o.end ? this.end-o.end : this.start - o.start;
		}
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		Meeting[] meetings = new Meeting[N];  // 회의 리스트들 (회의는 시작시간과 종료시간을 갖는다)
		for (int i = 0; i < N; i++) {
			meetings[i] = new Meeting(sc.nextInt(), sc.nextInt());
		}
		
		
		Arrays.sort(meetings);
		ArrayList<Meeting> result = new ArrayList<>();  // 선정된 회의를 담는 리스트
		result.add(meetings[0]);
		
		int last = 0;
		for (int i = 1; i < N; i++) {
			if (result.get(result.size() - 1).end <= meetings[i].start) {
				result.add(meetings[i]);
			}
		}
	
		System.out.println("최대로 배치 가능한 회의 수" + result.size());
		for (Meeting meeting : result) {
			System.out.println(meeting.start + " " + meeting.end);
		}
	}

}
