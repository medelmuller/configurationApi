http://localhost:8080/swagger-ui/index.html#/





POST ENDPOINT:
localhost:8080/configurations
Content-Type: application/json

{
"identifier": "TEST00123",
"configuration": "{\"server\":{\"ip\":\"192.168.0.90\",\"mask\":\"255.255.255.0\",\"gate\":\"192.168.0.1\",\"port\":80,\"dhcp\":false},\"dns\":{\"addrone\":\"8.8.8.8\",\"addrtwo\":\"8.8.4.4\",\"addrthree\":\"0.0.0.0\",\"addrfour\":\"0.0.0.0\"},\"client\":{\"host\":\"tdl.es-t.pl\",\"port\":2055},\"rtc\":{\"time\":1541504880,\"lastdataread\":1541504781,\"host\":\"tempus1.gum.gov.pl\",\"autosync\":true,\"clientinterval\":900,\"sntpinterval\":86850,\"datasaveinterval\":900,\"updateinterval\":30},\"info\":{\"mac\":\"54:10:ec:f4:c8:fc\",\"id\":\"TDLFORTEST_S\",\"apiversion\":\"2.0.0 - TS\",\"lastconfigstatus\":true,\"lastdatastatus\":true},\"onewire\":{\"data\":[],\"total\":0},\"registers\":{\"data\":[{\"id\":20000,\"reg\":40001,\"val\":25.900000,\"opt\":1073742084,\"divisor\":10.000000,\"dev\":10000,\"unit\":\"C\",\"desc\":\"TDL temperature\"},{\"id\":20001,\"reg\":40002,\"val\":23.800000,\"opt\":1073742340,\"divisor\":10.000000,\"dev\":10000,\"unit\":\"V\",\"desc\":\"TDL supply\"}],\"total\":2},\"devices\":{\"data\":[{\"id\":10000,\"slave\":0,\"baud\":9600,\"mode\":\"rtu\",\"frame\":0,\"name\":\"TDL parametrs\",\"desc\":\"TDL temperature and supply\",\"registers\":{\"data\":[{\"id\":20000,\"reg\":40001,\"val\":25.900000,\"opt\":1073742084,\"divisor\":10.000000,\"unit\":\"C\",\"desc\":\"TDL temperature\"},{\"id\":20001,\"reg\":40002,\"val\":23.800000,\"opt\":1073742340,\"divisor\":10.000000,\"unit\":\"V\",\"desc\":\"TDL supply\"}],\"total\":2}}],\"total\":1},\"pozyton\":{\"data\":[],\"total\":0},\"templates\":{\"data\":[],\"total\":0}}",
"deviceId":  1
}

GET ENDPOINT:
localhost:8080/configurations/1
Accept: application/json

PUT ENDPOINT:
localhost:8080/configurations/1
Content-Type: application/json

{
"identifier": "TEST00123",
"configuration": "{\"server\":{\"ip\":\"192.168.0.90\",\"mask\":\"255.255.255.0\",\"gate\":\"192.168.0.1\",\"port\":80,\"dhcp\":false},\"dns\":{\"addrone\":\"8.8.8.8\",\"addrtwo\":\"8.8.4.4\",\"addrthree\":\"0.0.0.0\",\"addrfour\":\"0.0.0.0\"},\"client\":{\"host\":\"tdl.es-t.pl\",\"port\":2055},\"rtc\":{\"time\":1541504880,\"lastdataread\":1541504781,\"host\":\"tempus1.gum.gov.pl\",\"autosync\":true,\"clientinterval\":900,\"sntpinterval\":86850,\"datasaveinterval\":900,\"updateinterval\":30},\"info\":{\"mac\":\"54:10:ec:f4:c8:fc\",\"id\":\"TDLFORTEST_S\",\"apiversion\":\"2.0.0 - TS\",\"lastconfigstatus\":true,\"lastdatastatus\":true},\"onewire\":{\"data\":[],\"total\":0},\"registers\":{\"data\":[{\"id\":20000,\"reg\":40001,\"val\":25.900000,\"opt\":1073742084,\"divisor\":10.000000,\"dev\":10000,\"unit\":\"C\",\"desc\":\"TDL temperature\"},{\"id\":20001,\"reg\":40002,\"val\":23.800000,\"opt\":1073742340,\"divisor\":10.000000,\"dev\":10000,\"unit\":\"V\",\"desc\":\"TDL supply\"}],\"total\":2},\"devices\":{\"data\":[{\"id\":10000,\"slave\":0,\"baud\":9600,\"mode\":\"rtu\",\"frame\":0,\"name\":\"TDL parametrs\",\"desc\":\"TDL temperature and supply\",\"registers\":{\"data\":[{\"id\":20000,\"reg\":40001,\"val\":25.900000,\"opt\":1073742084,\"divisor\":10.000000,\"unit\":\"C\",\"desc\":\"TDL temperature\"},{\"id\":20001,\"reg\":40002,\"val\":23.800000,\"opt\":1073742340,\"divisor\":10.000000,\"unit\":\"V\",\"desc\":\"TDL supply\"}],\"total\":2}}],\"total\":1},\"pozyton\":{\"data\":[],\"total\":0},\"templates\":{\"data\":[],\"total\":0}}",
"deviceId":  1
}

DELETE ENDPOINT:
localhost:8080/configurations/1