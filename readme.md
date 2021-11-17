# <div align='center'><font size='70'>keep alive</font></div>

<!-- ### 记录一下开发中遇到的问题 -->


|  模块   | 功能  | 备注  |
|  ----  | ----  | ----  |
| keep-dependencies | 依赖版本控制 | 初版 |
| keep-blog | 自用笔记系统 | 初版 |


### local 开发不需要验证权限，其他环境如dev uat prod需要验证权限

http://localhost:8001/swagger-ui.html

### Druid密码加密
set Path=%PATH%;D:\devsoft\Java\jdk1.8.0_231\bin
cd /d D:\devsoft\.m2\repository\com\alibaba\druid\1.2.8
java -cp druid-1.2.8.jar com.alibaba.druid.filter.config.ConfigTools dear

privateKey:MIIBVgIBADANBgkqhkiG9w0BAQEFAASCAUAwggE8AgEAAkEAlTHmu/Uaozbdy7JQGwLcdXKTxULbxTceWkbkNhLyLeI5xuSzxAbr6QldyWA93X1jUPGAhAc23fK7FKWKwqUTdwIDAQABAkEAg/bPkBEMrrEpHbNrB3lQZtIhwqmQmrBWOKPb17iKXeoSUrMO44Ihwtz9w1jKLf5dITGv/ILjl4tNbPI1tTt+gQIhAMUxDZTk0RiAjFoGy7yYvPeV5hdVkxhavLhlwxunywqNAiEAwbB0ixfyCjfPMGpeLbgHzwJqg3mNWB/wY4VorPhLNxMCIQC59/QWGuHz2LAE62nTeLymRtFT6lmqW1CmGxqxh0JetQIgHfTEkZ6qeJoZGUvaNQf5bTLadmseSTrnWv0PK3FbcLECIQCOSwL1GJoTrMcf7MztDQSdHk0Sxnz1q6ei1n0ErPDR+w==
publicKey:MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJUx5rv1GqM23cuyUBsC3HVyk8VC28U3HlpG5DYS8i3iOcbks8QG6+kJXclgPd19Y1DxgIQHNt3yuxSlisKlE3cCAwEAAQ==
password:XGH1plMysadHSIpHpV9l03q73fH+ztdxDomFWZddQRGIsePz7zKzrwlYT1e3ZKfRl0zXNYRSUs/cKjLQmiYC7w==

    public static void main(String[] args) {
        String pubKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJUx5rv1GqM23cuyUBsC3HVyk8VC28U3HlpG5DYS8i3iOcbks8QG6+kJXclgPd19Y1DxgIQHNt3yuxSlisKlE3cCAwEAAQ==";
        String privateKey = "MIIBVgIBADANBgkqhkiG9w0BAQEFAASCAUAwggE8AgEAAkEAlTHmu/Uaozbdy7JQGwLcdXKTxULbxTceWkbkNhLyLeI5xuSzxAbr6QldyWA93X1jUPGAhAc23fK" +
                "7FKWKwqUTdwIDAQABAkEAg/bPkBEMrrEpHbNrB3lQZtIhwqmQmrBWOKPb17iKXeoSUrMO44Ihwtz9w1jKLf5dITGv/ILjl4tNbPI1tTt+gQIhAMUxDZTk0RiAjFoGy7yYvPeV5h" +
                "dVkxhavLhlwxunywqNAiEAwbB0ixfyCjfPMGpeLbgHzwJqg3mNWB/wY4VorPhLNxMCIQC59/QWGuHz2LAE62nTeLymRtFT6lmqW1CmGxqxh0JetQIgHfTEkZ6qeJoZGUvaNQf5b" +
                "TLadmseSTrnWv0PK3FbcLECIQCOSwL1GJoTrMcf7MztDQSdHk0Sxnz1q6ei1n0ErPDR+w==";
        String username = "admin";
        String password = "admin123";
        try {
            System.out.println(ConfigTools.encrypt(privateKey, username)); // hxv8J3YTAq/ESlVaNL0Jlo9xTnNv6QhSKpEMqHwvXIH/gxTUMcePHDNUxFJmMe5O+/fOg+GcSp50AY9EDfviCQ==
            System.out.println(ConfigTools.decrypt(pubKey, "hxv8J3YTAq/ESlVaNL0Jlo9xTnNv6QhSKpEMqHwvXIH/gxTUMcePHDNUxFJmMe5O+/fOg+GcSp50AY9EDfviCQ==")); // admin

            System.out.println(ConfigTools.encrypt(privateKey, password)); // Xqo7htDwRffrF3XMMNRyD8zwph1veEHuoir2pDgGYTzzNC2CDaDQ1uVyR8JznsAqIbVIv1VIqnT6HO3VAn80rQ==
            System.out.println(ConfigTools.decrypt(pubKey, "Xqo7htDwRffrF3XMMNRyD8zwph1veEHuoir2pDgGYTzzNC2CDaDQ1uVyR8JznsAqIbVIv1VIqnT6HO3VAn80rQ==")); // admin
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
## 登录
数据库: dear/dear
druid monitor: admin/admin123

set Path=%PATH%;D:\devsoft\Java\jdk1.8.0_231\bin
java -cp D:\devsoft\.m2\repository\com\h2database\rh2\1.4.200\h2-1.4.200.jar org.h2.tools.Console -tcpAllowOthers -webAllowOthers -webPort 8082

http://localhost:8001/druid/index.html

http://localhost:8001/category/loadAll

curl -i http://localhost:8001/article/loadAll

curl -i http://localhost:8001/category/loadAll



curl -H 'Authorization:Basic Y2xpZW50LTE6c2VjcmV0LTE=' -i -d "grant_type=password&scope=all&username=lily&password=abc" http://localhost:7001/auth/oauth/token

curl -i -d "grant_type=password&scope=all&username=lily&password=abc&client_id=client-1&client_secret=secret-1" http://localhost:7001/auth/oauth/token

curl -i http://localhost:8001/category/loadAll -H "Authorization: Bearer fcfca132-f999-4ee2-b148-871edf183f70"

login h2 console
jdbc:h2:file:D:/devsoft/db/devDb;AUTO_SERVER=TRUE;DB_CLOSE_DELAY=-1;
jdbc:h2:file:D:/devsoft/db/securityDb;AUTO_SERVER=TRUE;DB_CLOSE_DELAY=-1;