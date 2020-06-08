# oauth_server
oauth2 server embedded with resource server

## Get token request
curl --location --request POST 'http://localhost:8088/oauth/token' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--header 'Cookie: JSESSIONID=72571279D35B278C237AB247DFF5BC4C' \
--data-urlencode 'username=username' \
--data-urlencode 'password=password' \
--data-urlencode 'grant_type=password' \
--data-urlencode 'client_id=client_id' \
--data-urlencode 'client_secret=client_secret'

response:
{
    "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsicmVzb3VyY2VfaWQiXSwidXNlcl9uYW1lIjoidXNlcm5hbWUiLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiLCJ0cnVzdCJdLCJleHAiOjE1OTE2MDE4MDQsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJqdGkiOiI4NGNhNThmYy02MmY3LTRiYTktYjQ3ZC02YTk5MGU5Nzk5YTQiLCJjbGllbnRfaWQiOiJjbGllbnRfaWQifQ.bsjZDU8XhjqPpQzjyli80S106UztsZ3u18ocTYvxYqY",
    "token_type": "bearer",
    "refresh_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsicmVzb3VyY2VfaWQiXSwidXNlcl9uYW1lIjoidXNlcm5hbWUiLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiLCJ0cnVzdCJdLCJhdGkiOiI4NGNhNThmYy02MmY3LTRiYTktYjQ3ZC02YTk5MGU5Nzk5YTQiLCJleHAiOjE1OTE2NDE0MDQsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJqdGkiOiI0NjkxNGQ5ZS0zMDY1LTQwN2QtYmFmMC1hNzI5MDc5ODM4ZjYiLCJjbGllbnRfaWQiOiJjbGllbnRfaWQifQ.Wiv4qrUvDl_lpN48xr2UROLWGY-QqbornpMAKwlIbY8",
    "expires_in": 3571,
    "scope": "read write trust",
    "jti": "84ca58fc-62f7-4ba9-b47d-6a990e9799a4"
}

## accessing API using the token
curl --location --request GET 'http://localhost:8088/gettest' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsicmVzb3VyY2VfaWQiXSwidXNlcl9uYW1lIjoidXNlcm5hbWUiLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiLCJ0cnVzdCJdLCJleHAiOjE1OTE1OTcwMzksImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJqdGkiOiJmZWZmZDIzMC0wMDQ4LTQzNGItOTQ0OC0wYzZiZGI0NmRjYTciLCJjbGllbnRfaWQiOiJjbGllbnRfaWQifQ.eQpkP0Ysb5lpRStjgrEwJeXbNhp1u6klPJDApulKTUM' \
--header 'Cookie: JSESSIONID=72571279D35B278C237AB247DFF5BC4C'

response:
GET success
