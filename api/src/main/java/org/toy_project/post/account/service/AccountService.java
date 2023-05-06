package org.toy_project.post.account.service;

import org.springframework.stereotype.Service;
import org.toy_project.post.account.dto.AccountResponse;

@Service
public class AccountService {

    public AccountResponse getAccount(Long id) {
        return AccountResponse.builder()
                .id(id)
                .accountName("jennierubyjane")
                .postCount(89)
                .followCount(0)
                .followerCount(999)
                .accountImage(AccountResponse.AccountImage.builder()
                        .id(1L)
                        .type("profile")
                        .imageUrl("https://scontent-ssn1-1.cdninstagram.com/v/t51.2885-19/71533411_449636125903525_7464596574253875200_n.jpg?stp=dst-jpg_s320x320&_nc_ht=scontent-ssn1-1.cdninstagram.com&_nc_cat=1&_nc_ohc=46Hei6zgefcAX_ZYID0&edm=AOQ1c0wBAAAA&ccb=7-5&oh=00_AfBDTYWtogBWVxTSXTuu1-SZpHe4C9nrPXByBa98E7ljmQ&oe=645B8991&_nc_sid=8fd12b")
                        .build())
                .hashTag("@lesyeuxdenini")
                .youtubeUrl("https://youtu.be/JyBd-qPKqpU")
                .build();
    }
}
