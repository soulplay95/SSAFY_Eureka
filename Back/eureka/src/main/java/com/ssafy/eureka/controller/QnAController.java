package com.ssafy.eureka.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.eureka.dto.Comment;
import com.ssafy.eureka.dto.Member;
import com.ssafy.eureka.dto.QnA;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RequestMapping("/qna")
@Api(value = "eureka")
public class QnAController {

    @ApiOperation(value ="모든 QnA 리스트", notes = "모든 QnA의 정보를 반환한다.", response = List.class)
	@GetMapping
	public ResponseEntity<List<QnA>> retrieveQnA() throws Exception {
		return null;
	}

    @ApiOperation(value ="QnA 정보", notes =  "글번호에 해당하는 QnA의 정보를 반환한다.", response = QnA.class)
	@GetMapping("{no}")
	public ResponseEntity<QnA> QnADetail(@PathVariable int no) {
    	return null;
	}

    @ApiOperation(value = "QnA 등록", notes = "새로운 QnA 정보를 입력한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> writeQnA(@RequestBody QnA QnA) {
    	return null;
	}

    @ApiOperation(value = "QnA 수정", notes = "글번호에 해당하는 QnA의 정보를 수정한다.", response = String.class)
	@PutMapping("{no}")
	public ResponseEntity<String> updateQnA(@RequestBody QnA QnA) {
    	return null;
	}

    @ApiOperation(value = "QnA 삭제", notes = "글번호에 해당하는 QnA의 정보를 삭제한다.", response = String.class)
	@DeleteMapping("{no}")
	public ResponseEntity<String> deleteQnA(@PathVariable int no) {
    	return null;
	}

//	@ApiOperation(value = "답글 정보", notes = "글번호에 해당하는 답글의 정보를 반환한다.", response = Comment.class)
//	@GetMapping("/comment/{articleno}")
//	public ResponseEntity<Comment> getComment(@PathVariable int articleno) {
//		return null;
//	}

	@ApiOperation(value = "답글 등록", notes = "새로운 답글 정보를 입력한다.", response = String.class)
	@PostMapping("/comment")
	public ResponseEntity<String> writeComment(@RequestBody Comment comment) {
		return null;
	}

	@ApiOperation(value = "답글 수정", notes = "글번호에 해당하는 답글의 정보를 수정한다.", response = String.class)
	@PutMapping("/comment/{no}")
	public ResponseEntity<String> updateComment(@RequestBody Comment comment) {
		return null;
	}

	@ApiOperation(value = "답글 삭제", notes = "글번호에 해당하는 답글의 정보를 삭제한다.", response = String.class)
	@DeleteMapping("/comment/{commentno}")
	public ResponseEntity<String> deleteComment(@PathVariable int commentno) {
		return null;
	}

}
