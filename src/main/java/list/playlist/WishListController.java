package list.playlist;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


import list.playlist.dto.WishDto;
import list.playlist.service.WishListService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class WishListController {

	private final WishListService wishListService;
	
	@PostMapping(value="/wishlist")
	ResponseEntity order(@RequestBody @Valid WishDto wishDto,
			BindingResult bindingResult, Principal principal) {
	//위시리스트에 담을 플레이리스트 정보를 받는 wishDto 객체에 데이터 바인딩시 에러가 있는지 검사
	if(bindingResult.hasErrors()) {
		StringBuilder sb = new StringBuilder();
		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
		for(FieldError fieldError : fieldErrors) {
			sb.append(fieldError.getDefaultMessage());
		}
		return new ResponseEntity<String>(sb.toString(),HttpStatus.BAD_REQUEST);
	}
	//현재 로그인한 회원의 아이디 정보를 변수에 저장
	String userId = principal.getName();
	Long wishId;
	//화면으로부터 넘어온 위시리스트에 담을 플레이리스트정보와 현재 로그인한 회원의 아이디 정보를 이용하여 
	//위시리스트에 플레이리스트를 담을 로직을 호출한다.
	try {
		//wishListService의 addWishList 메소드를 예외처리 했기떄문에 try catch 사용해야함 
		wishId = wishListService.addWishList(wishDto, userId);
	}catch(Exception e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	//결과값으로 생성된 위시리시스트 wish아이디와 요청이 성공하였다는 HTTP 응답상태 코드를 반환
	return new ResponseEntity<Long>(wishId,HttpStatus.OK);	
}
}
