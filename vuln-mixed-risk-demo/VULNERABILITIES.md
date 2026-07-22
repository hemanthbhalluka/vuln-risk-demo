# Answer Key

| Severity | CWE | Title | File |
|---|---|---|---|
| HIGH | CWE-89  | SQL Injection | controller/SQLiUserController.java |
| HIGH | CWE-78  | OS Command Injection | service/CommandService.java |
| HIGH | CWE-918 | Server-Side Request Forgery | controller/ProxyController.java |
| MEDIUM | CWE-327 | Weak Hash Algorithm (MD5) | service/HashService.java |
| MEDIUM | CWE-330 | Insecure Randomness | service/TokenService.java |
| MEDIUM | CWE-352 | CSRF Disabled / Missing Authorization | config/SecurityConfig.java |
| LOW | CWE-614 | Insecure Cookie Flags | controller/CookieController.java |
| LOW | CWE-942 | Overly Permissive CORS | controller/CorsController.java |
| LOW | CWE-209 | Information Exposure via Error Message | controller/DebugController.java |

Every planted file also has an inline `// VULN: CWE-xxx (SEVERITY)` comment.
Run `grep -rn "VULN:" src` from the project root to list them all.
