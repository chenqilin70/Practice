
CREATE TABLE ADDRESS
(
	ADDRESSID INT NOT NULL AUTO_INCREMENT COMMENT '��ַ���',
	PROVINCE VARCHAR(20) NOT NULL UNIQUE COMMENT 'ʡ��',
	CITY VARCHAR(20) NOT NULL COMMENT '����',
	AREA VARCHAR(20) NOT NULL COMMENT '����',
	STREET VARCHAR(200) COMMENT '�ֵ�',
	DETAIL VARCHAR(200) COMMENT '��ϸ',
	TEL VARCHAR(11) NOT NULL COMMENT '�绰',
	USER VARCHAR(20) COMMENT '��ϵ��',
	USERID INT NOT NULL COMMENT '�û����',
	PRIMARY KEY (ADDRESSID)
) COMMENT = '�ջ���ַ�� : �ջ���ַ��';



CREATE TABLE ORDERITEMS
(
	ORDERITEMID INT NOT NULL AUTO_INCREMENT COMMENT '���',
	COUNT INT NOT NULL COMMENT '����',
	DISCOUNT FLOAT NOT NULL COMMENT '�ۿ�',
	ORDERID INT NOT NULL COMMENT '�������',
	PRODUCTID INT NOT NULL COMMENT '��Ʒ���',
	PRIMARY KEY (ORDERITEMID)
) COMMENT = '��������� : ����������Ϣ��';


CREATE TABLE ORDERS
(
	ORDERID INT NOT NULL AUTO_INCREMENT COMMENT '���',
	TIME DATETIME NOT NULL COMMENT 'ʱ��',
	STATUS INT NOT NULL COMMENT '״̬',
	USERID INT NOT NULL COMMENT '�û����',
	ADDRESSID INT NOT NULL COMMENT '��ַ���',
	PRIMARY KEY (ORDERID)
) COMMENT = '������ : �洢������Ϣ�ı�';



CREATE TABLE PRODUCT
(
	PRODUCTID INT NOT NULL AUTO_INCREMENT COMMENT '���',
	NAME VARCHAR(100) NOT NULL COMMENT '��Ʒ����',
	BRAND VARCHAR(20) NOT NULL COMMENT 'Ʒ��',
	TYPE VARCHAR(10) NOT NULL COMMENT '�ʺ���Ⱥ',
	SERIS VARCHAR(20) NOT NULL COMMENT '����',
	DESCRIPTION VARCHAR(1000) COMMENT '����',
	BASICPRICE FLOAT NOT NULL COMMENT '�۸�',
	TYPEID INT NOT NULL COMMENT '���ͱ��',
	image VARCHAR(25) NOT NULL COMMENT 'ͼƬ',
	PRIMARY KEY (PRODUCTID)
) ENGINE = InnoDB COMMENT = '��Ʒ�� : ��Ʒ�����';



CREATE TABLE PRODUCTIMAGE
(
	PRODUCTIMAGEID INT NOT NULL AUTO_INCREMENT COMMENT '���',
	PATH VARCHAR(20) NOT NULL COMMENT 'ͼƬ·��',
	ENABLE BIT(1) NOT NULL COMMENT '�Ƿ����',
	PRODUCTID INT NOT NULL COMMENT '��Ʒ���',
	PRIMARY KEY (PRODUCTIMAGEID)
) COMMENT = '��ƷͼƬ�� : �洢ͼƬ·���ı�';



CREATE TABLE PRODUCTMODELTYPE
(
	MODELTYPEID INT NOT NULL AUTO_INCREMENT COMMENT '�ͺű��',
	SIZE VARCHAR(20) NOT NULL COMMENT '�ߴ�',
	COLOR VARCHAR(20) NOT NULL COMMENT '��ɫ',
	PRICE FLOAT NOT NULL COMMENT '�۸�',
	COUNTS INT COMMENT '���',
	PRODUCTID INT NOT NULL COMMENT '��Ʒ���',
	PRIMARY KEY (MODELTYPEID)
) COMMENT = '��Ʒ�ͺ������ : �洢��Ʒ��ͬ�ͺ���Ϣ�ı�';



CREATE TABLE PRODUCTTYPE
(
	PRODUCTTYPEID INT NOT NULL AUTO_INCREMENT COMMENT '���',
	TYPENAME VARCHAR(20) NOT NULL COMMENT '������',
	PRIMARY KEY (PRODUCTTYPEID)
) COMMENT = '��Ʒ���ͱ� : �洢��Ʒ���͵ı�';



CREATE TABLE USERS
(
	USERID INT NOT NULL AUTO_INCREMENT COMMENT '�û����',
	USERNAME VARCHAR(20) NOT NULL UNIQUE COMMENT '�û���',
	PASSWORD VARCHAR(30) NOT NULL COMMENT '����',
	REALNAME VARCHAR(20) NOT NULL COMMENT '��ʵ����',
	SEX BIT(1) COMMENT '�Ա�',
	AGE INT COMMENT '����',
	IMAGE VARCHAR(50) COMMENT 'ͷ��',
	STATUS BIT(1) COMMENT '״̬',
	PRIMARY KEY (USERID)
) ENGINE = InnoDB COMMENT = '�û���Ϣ�� : ���Ǵ洢�û���Ϣ�ı�' DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;




ALTER TABLE ORDERS
	ADD FOREIGN KEY (ADDRESSID)
	REFERENCES ADDRESS (ADDRESSID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE ORDERITEMS
	ADD FOREIGN KEY (ORDERID)
	REFERENCES ORDERS (ORDERID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE ORDERITEMS
	ADD FOREIGN KEY (PRODUCTID)
	REFERENCES PRODUCT (PRODUCTID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE PRODUCTIMAGE
	ADD FOREIGN KEY (PRODUCTID)
	REFERENCES PRODUCT (PRODUCTID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE PRODUCTMODELTYPE
	ADD FOREIGN KEY (PRODUCTID)
	REFERENCES PRODUCT (PRODUCTID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE PRODUCT
	ADD FOREIGN KEY (TYPEID)
	REFERENCES PRODUCTTYPE (PRODUCTTYPEID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE ADDRESS
	ADD FOREIGN KEY (USERID)
	REFERENCES USERS (USERID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE ORDERS
	ADD FOREIGN KEY (USERID)
	REFERENCES USERS (USERID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;




