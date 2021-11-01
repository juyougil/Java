package com.staff.prj.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.staff.prj.dto.StaffDTO;

import java.util.regex.Pattern;


//MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
// BoardDTO 객체에 저장된 데이터의 유효성 체크할 BoardValidator 클래스 선언하기
//MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
public class StaffValidator implements Validator {

	//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
	//  유효성 체크할 객체의 클래스 타입 정보 얻어 리턴하기
	//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
	@Override
	public boolean supports(Class<?> arg0) {
		return StaffDTO.class.isAssignableFrom(arg0);  // 검증할 객체의 클래스 타입 정보
	}

	//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
	//  유효성 체크할 메소드 선언하기
	//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
	@Override
	public void validate(
		Object obj          // DTO 객체 저장 매개변수
		, Errors errors     // 유효성 검사 시 발생하는 에러를 관리하는 Errors 객체 저장 매개변수
	){
		try {
			//nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn
			// 유효성 체크할 DTO 객체 얻기
			//nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn
			StaffDTO dto = (StaffDTO)obj;

			//        String sWriter = dto.getWriter();
			//        if(sWriter == null || sWriter.trim().isEmpty()) {
			//            System.out.println("Writer is null or empty");
			//            errors.rejectValue("writer", "trouble");
			//        }


			//nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn
			//nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn
			// ValidationUtils 클래스의 rejectIfEmptyOrWhitespace 메소드 호출하여
			//		BoardDTO 객체의 속성변수명 writer 이 비거나 공백으로 구성되어 있으면
			//		경고 메시지를 Errors 객체에 저장하기
			//nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn
			ValidationUtils.rejectIfEmptyOrWhitespace(
				errors                       // Errors 객체
				, "staff_name"                   // BoardDTO 객체의 속성변수명
				, "사원명을 입력해주세요."        // BoardDTO 객체의 속성변수명이 비거나 공백으로 구성되어 있을때 경고 문구
			);
			//nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn
			// BoardDTO 객체의 속성변수명 "writer" 저장된 데이터의 길이가 10자 보다 크면
			// Errors 객체에 속성변수명 "writer" 과 경고 메시지 저장하기
			//nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn
			String staff_name = dto.getStaff_name();
			if(Pattern.matches("^[가-힣a-zA-Z]{2,10}$", staff_name)==false ) {
				errors.rejectValue("staff_name", "사원명은 영문또는 한글로 2자 이상 10자 이하여야 합니다. 다시 입력해주세요.");
			}

			//nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn
			//nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn
			// ValidationUtils 클래스의 rejectIfEmptyOrWhitespace 메소드 호출하여
			//		BoardDTO 객체의 속성변수명 writer 이 비거나 공백으로 구성되어 있으면
			//		경고 메시지를 Errors 객체에 저장하기
			//nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn
			ValidationUtils.rejectIfEmptyOrWhitespace(
				errors                       // Errors 객체
				, "front_jumin_no"                   // BoardDTO 객체의 속성변수명
				, "주민번호 앞자리를 입력해주세요."         // BoardDTO 객체의 속성변수명이 비거나 공백으로 구성되어 있을때 경고 문구
			);
			//nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn
			// BoardDTO 객체의 속성변수명 "subject" 저장된 데이터의 길이가 30자 보다 크면
			// Errors 객체에 속성변수명 "subject" 과 경고 메시지 저장하기
			//nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn
			String front_jumin_no = dto.getFront_jumin_no();
			if( Pattern.matches("^[0-9]{2}(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|[3][01])", front_jumin_no)==false ) {
				errors.rejectValue("front_jumin_no", "앞자리 주민번호가 유효하지 않습니다 다시 입력해주세요.");
			}
			
			
			ValidationUtils.rejectIfEmptyOrWhitespace(
					errors                       // Errors 객체
					, "back_jumin_no"                   // BoardDTO 객체의 속성변수명
					, "주민번호 뒷자리를 입력해주세요."         // BoardDTO 객체의 속성변수명이 비거나 공백으로 구성되어 있을때 경고 문구
				);
				//nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn
				// BoardDTO 객체의 속성변수명 "subject" 저장된 데이터의 길이가 30자 보다 크면
				// Errors 객체에 속성변수명 "subject" 과 경고 메시지 저장하기
				//nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn
				String back_jumin_no = dto.getBack_jumin_no();
				if( Pattern.matches("[0|1|2|3|4|9]{1}([0-8][0-9]|[9][0-6])[0-9]{4}$", back_jumin_no)==false ) {
					errors.rejectValue("back_jumin_no", "뒷자리 주민번호가 유효하지 않습니다 다시 입력해주세요.");
				}
				
				
				
			ValidationUtils.rejectIfEmptyOrWhitespace(
					errors                    // Errors 객체
					, "religion_code"                 // BoardDTO 객체의 속성변수명
					, "종교 선택를 선택해주세요. 종교가 없을 시 무교를 선택해주세요."         // BoardDTO 객체의 속성변수명이 비거나 공백으로 구성되어 있을때 경고 문구
				);
			//nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn
			//nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn
			// ValidationUtils 클래스의 rejectIfEmptyOrWhitespace 메소드 호출하여
			//		BoardDTO 객체의 속성변수명 writer 이 비거나 공백으로 구성되어 있으면
			//		경고 메시지를 Errors 객체ㅇ에 저장하기
			//nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn
			ValidationUtils.rejectIfEmptyOrWhitespace(
				errors                    // Errors 객체
				, "school_code"                 // BoardDTO 객체의 속성변수명
				, "학력을 선택해주세요."         // BoardDTO 객체의 속성변수명이 비거나 공백으로 구성되어 있을때 경고 문구
			);
			ValidationUtils.rejectIfEmptyOrWhitespace(
					errors                    // Errors 객체
					, "skill_code"                 // BoardDTO 객체의 속성변수명
					, "스킬은 하나 이상 선택해주세요."         // BoardDTO 객체의 속성변수명이 비거나 공백으로 구성되어 있을때 경고 문구
				);

			//nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn
			//nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn
			// ValidationUtils 클래스의 rejectIfEmptyOrWhitespace 메소드 호출하여
			//		BoardDTO 객체의 속성변수명 writer 이 비거나 공백으로 구성되어 있으면
			//		경고 메시지를 Errors 객체에 저장하기
			//nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn
			ValidationUtils.rejectIfEmptyOrWhitespace(
				errors                    // Errors 객체
				, "graduate_day"                 // BoardDTO 객체의 속성변수명
				, "졸업일을 선택해주세요."         // BoardDTO 객체의 속성변수명이 비거나 공백으로 구성되어 있을때 경고 문구
			);


		}catch(Exception ex) {
			System.out.println( "BoardValidator.validate 메소드 실행 시 예외발생!" );
		}
	}
    
}
