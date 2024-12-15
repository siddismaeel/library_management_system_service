package com.lms.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.dto.request.MemberRequestDTO;
import com.lms.dto.response.MemberDTO;
import com.lms.dto.response.MemberDropdownDTO;
import com.lms.model.Member;
import com.lms.repository.MemberRepository;
import com.lms.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository memberRepository;
	private final ModelMapper mapper = new ModelMapper();
	@Override
	public MemberDTO getMember(Long memberId) {
		
		Member member = memberRepository.findById(memberId).orElseThrow(()->new IllegalIdentifierException("Member not found."));
		return mapper.map(member, MemberDTO.class);
	}

	@Override
	public List<MemberDTO> getAllMembers() {
		List<Member> memberList = memberRepository.findAll();
		memberList.stream().filter(member->member.getId() == 3).forEach(member->System.out.println(member.getIssuedBooks()));
		return memberList.stream().map(member-> mapper.map(member, MemberDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public MemberDTO saveMember(MemberRequestDTO memberRequest) {
		
		Member member = memberRepository.findById(memberRequest.getMemberId()).orElse(new Member());
		member.setEmail(memberRequest.getEmail());
		member.setFirstName(memberRequest.getFirstName());
		member.setLastName(memberRequest.getLastName());
		member.setMembershipDate(memberRequest.getMembershipDate());
		member.setPhoneNumber(memberRequest.getPhoneNumber());
		
		Member savedMember = memberRepository.save(member);
		
		return mapper.map(savedMember, MemberDTO.class);
	}

	@Override
	public List<MemberDropdownDTO> getMembersForDropdown() {
		
		List<Member> members = memberRepository.findAll();
		
		return members.stream()
				.map(member->mapper.map(member, MemberDropdownDTO.class))
				.collect(Collectors.toList());
	}

}
