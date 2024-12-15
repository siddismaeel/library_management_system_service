package com.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.controller.response.GeneralResponse;
import com.lms.dto.request.MemberRequestDTO;
import com.lms.dto.response.MemberDTO;
import com.lms.dto.response.MemberDropdownDTO;
import com.lms.enums.ResponseStatus;
import com.lms.service.MemberService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@GetMapping("/get-member/{member_id}")
	public GeneralResponse<MemberDTO> getMember(@PathVariable("member_id") Long memberId) {
		GeneralResponse<MemberDTO> response = new GeneralResponse<>();

		MemberDTO member = memberService.getMember(memberId);

		response.setData(member);
		response.setMessage("");
		response.setStatus(ResponseStatus.SUCCESS);

		return response;
	}

	@GetMapping("/get-member-list")
	public GeneralResponse<List<MemberDTO>> getAllMembers() {
		GeneralResponse<List<MemberDTO>> response = new GeneralResponse<>();

		List<MemberDTO> memberList = memberService.getAllMembers();

		response.setData(memberList);
		response.setMessage("");
		response.setStatus(ResponseStatus.SUCCESS);

		return response;
	}

	@PostMapping("/save-member")
	public GeneralResponse<MemberDTO> saveMember(@RequestBody MemberRequestDTO memberRequest) {
		GeneralResponse<MemberDTO> response = new GeneralResponse<>();

		MemberDTO savedMember = memberService.saveMember(memberRequest);

		response.setData(savedMember);
		response.setMessage("Member saved.");
		response.setStatus(ResponseStatus.SUCCESS);

		return response;
	}

	@GetMapping("/get-member-dropdown")
	public GeneralResponse<List<MemberDropdownDTO>> getMembersForDropdown() {
		GeneralResponse<List<MemberDropdownDTO>> response = new GeneralResponse<>();

		List<MemberDropdownDTO> members = memberService.getMembersForDropdown();
		
		response.setData(members);
		response.setMessage("Member saved.");
		response.setStatus(ResponseStatus.SUCCESS);
		return response;

	}

}
