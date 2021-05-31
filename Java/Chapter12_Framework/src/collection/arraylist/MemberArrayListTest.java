package collection.arraylist;

import collection.Member;

public class MemberArrayListTest {

	public static void main(String[] args) {
		MemberArrayList memberArrayList = new MemberArrayList();
		Member memberLee = new Member(1001,"이지원");
		Member memberSon = new Member(1002,"손민국");
		Member memberPark = new Member(1003,"박서훤");
		Member memberHong = new Member(1004,"홍길동");
		/*
		memberArrayList.addMember(memberLee);
		memberArrayList.addMember(memberSon);
		memberArrayList.addMember(memberPark);
		memberArrayList.addMember(memberHong);
		*/
		//412쪽 혼자하기
		memberArrayList.insetMember(memberHong, 0);
		memberArrayList.insetMember(memberPark, 1);
		memberArrayList.insetMember(memberSon, 2);
		memberArrayList.insetMember(memberLee, 3);
		
		memberArrayList.showAllMember();
		memberArrayList.removeMember(memberHong.getMemberId());
		memberArrayList.showAllMember();
		
	}

}
