package com.librarymanagement.libmngsystem.service;

import com.librarymanagement.libmngsystem.exception.ResourceNotFoundException;
import com.librarymanagement.libmngsystem.entity.Member;
import com.librarymanagement.libmngsystem.repository.MemberRepository;
import com.librarymanagement.libmngsystem.validation.ContactInformationValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    private ContactInformationValidator contactInformationValidator;

    @Cacheable(value = "members", key = "#id")
    public Member getMemberById (Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member with id: " + id + " not found."));
    }


    @CachePut(value = "members", key = "#member.id")
    public Member createMember(Member member) {
        validateMemberContactInformation(member.getContactInformation());
        return memberRepository.save(member);
    }

    private void validateMemberContactInformation(Map<String, String> contactInformation) {
        contactInformationValidator.validateContactInformation(contactInformation);
    }
}
