package com.naver.erp;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
//[서비스 클래스]인 [BoardSeviceImpl 클래스] 선언
	// [서비스 클래스]에는 @Service @Transactional를 붙인다.
	// MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
	// @Service 		=> [서비스 클래스] 임을 지정하고 bean 태그로 자동 등록된다
	// @Transactional	=> [서비스 클래스]의 메소드 내부에서 일어나는 모든 작업에는 [트랜잭션]이 걸린다.
@Service
@Transactional
public class BoardServiceImpl implements BoardService {
	// 속성변수 boardDAO 선언하고, [BoardDAO 인테페이스]를 구현한 클래스를 객체화해서 저장한다.
		// @Autowired 역할 -> 속성변수에 붙은 자료형인 [인터페이스]를 구현한 [클래스]를 객체화하여 저장한다.
	
	@Autowired
	private BoardDAO boardDAO;
	
	
	// 업로드 파일의 저장 경로 저장하는 속성변수 선언하기
	// <주의> 경로가 문자열이므로 \를 \\ 로 써야함. \\ 대신의 /쓰지 말것
	String uploadDir = "D:\\kosmo\\workspace_sboot_01_2021.09.13.0940_파일업로드있는거\\prj01\\src\\main\\resources\\static\\resources\\img\\";
	
	
	// [1개 게시판 글 입력 후 입력 후 입력 적용 행의 개수] 리턴하는 메소드 선언
	public int insertBoard(BoardDTO boardDTO, MultipartFile multi) throws Exception{
		
		// 업로드한 파일의 새로운 이름 정하기
		// 업로드한 파일의 파일확장자 포함 새 파일명 저장변수 선언하기. 파일명에는 확장자가 포함한다.
		String newFileName = null;
		// 만약 업로드된 파일이 있으면
		if(multi!=null && multi.isEmpty()==false) {
			// 업로드한 파일의 원래 파일명 얻기. 파일명에는 확장자가 포함한다.
			String oriFileName = multi.getOriginalFilename();
			// 업로드한 파일의 파일확장자 얻기
			String file_extension = oriFileName.substring(oriFileName.lastIndexOf(".")+1);
			
			// 고유한 새 파일명 얻기. 파일명에는 확장자가 포함한다.
			newFileName = UUID.randomUUID() + "." + file_extension;
			boardDTO.setPic(newFileName);
			
		}
		
		
		
		// 만약 엄마글의 글 번호가 1 이상이면 댓글쓰기 이므로
		// 엄마 글 이후의 게시판 글에 대해 출력 순서번호를 1증가 시키기.
		if(boardDTO.getB_no()>0) {
			// BoardDAOImpl 객체의 updatePrintNo 메소드를 호출하여 출력 순서 번호를 1증가시키고
			// 수행정에 적용 개수를 리턴받는다.
			// 게시판 글이 입력되는 부분 이후 글들은 출력 순서번호를 1씩 증가하여야한다.
			// 게시판 테이블 분석 요망. 오늘 집에 가서 게시판 테이블 분석
			int updatePrintNoCnt = this.boardDAO.updatePrintNo(boardDTO);
			
		}
		// 파일업로드를 DB연동 전에 하면 안 되는 이유는 파일업로드가 성공했는데 DB연동에서 에러가 났을경우 파일업로드를 취소할수 없기 때문이다.
		
		
		// BoardDAOImpl 객체의 insertBoard 메소드 호출하여 게시판 글 입력 후 입력 적용 행의 개수 얻기
		int boardRegCnt = this.boardDAO.insertBoard(boardDTO);
		
		
		// 파일 업로드하기
		// 만약 업로드된 파일이 있으면
		if(multi!=null && multi.isEmpty()==false) {
			// 새 파일을 생성하기. File 객체를 생성하면 새 파일을 생성할수있다.
			File file = new File(uploadDir+newFileName);
			// 업로드한 파일을 새 파일에 전송하여 덮어쓰기
			multi.transferTo(file);
		}
		

		
		
		
		
		// 1개 게시판 글 입력 적용 행의 개수 리턴하기
		System.out.println("BoardServiceImpl 성공");
		return boardRegCnt;
	}
	


	// [1개 게시판 글] 리턴하는 메소드 선언
	public BoardDTO getBoard(int b_no) {
		
		
		
		//BoardDAOImpl 객체의 updateReadcount메소드 호출하여
		// 조회수 증가]하고 수정한 행의 개수를 얻는다.
		 int updateCnt = this.boardDAO.updateReadcount(b_no);
		 
		 if(updateCnt==0) {
			 return null;
		 }
		// BoardDAOImpl 객체의 getBoard 메소드를 호출하여
		// [1개 게시판 글]을 얻는다.
		BoardDTO boardDTO = this.boardDAO.getBoard(b_no);
		// [1개 게시판 글]이 저장된 BoardDTO 객체 리턴하기
		return boardDTO;
	}



	// [1개 게시판] 수정 실행하고 수정 적용행의 개수를 리턴하는 메소드 선언
	public int updateBoard(BoardDTO boardDTO, MultipartFile multi) throws Exception{
		// [BoardDAOImpl 객체]의 getBoardCnt메소드를 호출하여
		// 수정할 게시판의 존재 개수를 얻는다.
		int boardCnt = this.boardDAO.getBoardCnt(boardDTO);
		if(boardCnt==0) {return -1;}
		
		// [BoardDAOImpl 객체]의 getPwdCnt메소드를 호출하여
		// 수정할 게시판의 비밀번호 존재 개수를 얻는다.
		int pwdCnt = this.boardDAO.getPwdCnt(boardDTO);
		if(pwdCnt==0) {return -2;}
		
		
		// 업로드한 파일의 새로운 이름 정하기
		// 업로드한 파일의 파일확장자 포함 새 파일명 저장변수 선언하기. 파일명에는 확장자가 포함한다.
		String newFileName = null;
		String is_del = boardDTO.getIs_del();
		// 만약 업로드된 파일이 있으면
		if(multi!=null && multi.isEmpty()==false && is_del==null) {
			// 업로드한 파일의 원래 파일명 얻기. 파일명에는 확장자가 포함한다.
			String oriFileName = multi.getOriginalFilename();
			// 업로드한 파일의 파일확장자 얻기
			String file_extension = oriFileName.substring(oriFileName.lastIndexOf(".")+1);
			
			// 고유한 새 파일명 얻기. 파일명에는 확장자가 포함한다.
			newFileName = UUID.randomUUID() + "." + file_extension;
			boardDTO.setPic(newFileName);
			
		}
		// board 테이블에 있는 이미지 이름 가져오기
		String pic = this.boardDAO.getPic(boardDTO);
		
/*
		// 만약에 삭제가 체크되어 있고, 기존 이미지 파일명이 board 테이블에 존재하면
		if(pic!=null && is_del!=null) {
			// board 테이블에 이미지 명을 삭제
			int picDelCnt = this.boardDAO.delPic(boardDTO);
		}
*/		
		// [BoardDAOImpl 객체]의 updateBoard 메소드를 호출하여
		// 게시판 수정 명령한 후 수정 적용행의 개수를 얻는다.
		int updateCnt = this.boardDAO.updateBoard(boardDTO);
		

		// 파일 업로드하기
		// 만약 업로드된 파일이 있으면
		if(is_del==null) {
			if(multi!=null && multi.isEmpty()==false && is_del==null) {
				// 기존 이미지 파일 삭제하기
				// board 테이블에 이미지 이름이 있으면 파일 삭제하기
				if(pic!=null && pic.length()>0) {
					File file = new File(uploadDir + pic);
					file.delete();
				}
				// 새 파일을 생성하기. File 객체를 생성하면 새 파일을 생성할수있다.
				File file = new File(uploadDir+newFileName);
				// 업로드한 파일을 새 파일에 전송하여 덮어쓰기
				multi.transferTo(file);
			}
		}else {
			if(pic!=null) {
				File file = new File(uploadDir + pic);
				file.delete();
			}
		}
		
		return updateCnt;
	}


	// [1개 게시판] 삭제 후 삭제 적용행의 개수를 리턴하는 메소드 선언
	public int deleteBoard(BoardDTO boardDTO) {
		
		// board 테이블에 있는 이미지 이름 가져오기
		String pic = this.boardDAO.getPic(boardDTO);
		
		// [BoardDAOImpl 객체]의 getBoardCnt메소드를 호출하여
		// 삭제할 게시판의 존재 개수를 얻는다.
		int boardCnt = this.boardDAO.getBoardCnt(boardDTO);
		if(boardCnt==0) {return -1;}
		
		// [BoardDAOImpl 객체]의 getPwdCnt메소드를 호출하여
		// 삭제할 게시판의 비밀번호 존재 개수를 얻는다.
		int pwdCnt = this.boardDAO.getPwdCnt(boardDTO);
		if(pwdCnt==0) {return -2;}
		
		// [BoardDAOImpl 객체]의 getChildrenCnt 메소드를 호출하여
		// [삭제할 게시판의 자식글 존재 개수]를 얻는다.
		int childrenCnt = this.boardDAO.getChildrenCnt(boardDTO);
		if(childrenCnt>0) {return -3;}
		
		
		// [BoardDAOImpl 객체]의 downPrintNo메소드를 호출하여
		// [삭제될 게시판 이후 글의 출력 순서번호를 1씩 감소 시킨 후 수정 적용행의 개수]를 얻는다.
		int downPrintNoCnt = this.boardDAO.downPrintNo(boardDTO);
		
		
		// [BoardDAOImpl 객체]의 deleteBoard메소드를 호출하여
		// [게시판 삭제 명령한 후 삭제 적용행의 개수]를 얻는다.
		int deleteCnt = this.boardDAO.deleteBoard(boardDTO);
		
		
		// 기존 이미지 파일 삭제하기
		// board 테이블에 이미지 이름이 있으면 파일 삭제하기
		if(pic!=null && pic.length()>0) {
			File file = new File(uploadDir + pic);
			file.delete();
		}
		
		
		
		System.out.print("deleteCnt 성공");
		return deleteCnt;
	}

}
