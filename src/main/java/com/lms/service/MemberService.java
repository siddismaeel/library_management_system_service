package com.lms.service;

import java.util.List;

import com.lms.dto.request.MemberRequestDTO;
import com.lms.dto.response.MemberDTO;
import com.lms.dto.response.MemberDropdownDTO;

public interface MemberService {

	public MemberDTO getMember(Long memberId);
	public List<MemberDTO> getAllMembers();
	public MemberDTO saveMember(MemberRequestDTO memberRequest);
	public List<MemberDropdownDTO> getMembersForDropdown();
}
