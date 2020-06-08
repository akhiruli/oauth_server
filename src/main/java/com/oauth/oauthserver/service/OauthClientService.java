package com.oauth.oauthserver.service;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;

@Service
public class OauthClientService implements ClientDetailsService {
    static private String client_id="client_id";
    static private String client_secret="client_secret";
    static private Integer access_token_validity=3600;
    static private Integer refresh_token_validity=43200;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //you can get all below information from any source.
        BaseClientDetails base = new BaseClientDetails();
        base.setClientId(client_id);
        base.setClientSecret(passwordEncoder.encode(client_secret));
        base.setAccessTokenValiditySeconds(access_token_validity);
        base.setRefreshTokenValiditySeconds(refresh_token_validity);
        base.setAuthorizedGrantTypes(getGrantTypes("client_credentials,password,authorization_code,implicit,refresh_token"));
        base.setResourceIds(getResourceIds("resource_id"));
        base.setScope(this.getScopes("read,write,trust"));
        base.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));

        //base.setRegisteredRedirectUri(StringUtils.commaDelimitedListToSet("http://google.com"));

        return base;
    }

    private List<String> getAutoApproves(String autoapprove) {
        String a_arr[] = autoapprove.split(",");
        return Arrays.asList(a_arr);
    }

    private List<String> getGrantTypes(String grant_type){
        String g_arr[] = grant_type.split(",");
        return Arrays.asList(g_arr);

    }

    private List<String> getScopes(String scope){
        String s_arr[] = scope.split(",");
        return Arrays.asList(s_arr);
    }

    private List<String> getResourceIds(String resourceIds){
        String r_ids[] = resourceIds.split(",");
        return Arrays.asList(r_ids);
    }
}
