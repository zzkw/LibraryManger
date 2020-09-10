
DROP TABLE IF EXISTS `l_book`;
CREATE TABLE `l_book`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `press` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `version` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` float(10, 2) NULL DEFAULT NULL,
  `booktypeId` int(11) NOT NULL,
  `bookDesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `booktypeId`(`booktypeId`) USING BTREE,
  INDEX `bookName`(`bookName`) USING BTREE,
  CONSTRAINT `l_book_ibfk_1` FOREIGN KEY (`booktypeId`) REFERENCES `l_booktype` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of l_book
-- ----------------------------
INSERT INTO `l_book` VALUES (1, 'think in java', 'Bruce Eckel', '图灵出版社', '第五版', 67.80, 1, '编程技术');
INSERT INTO `l_book` VALUES (3, 'Java网络程序设计', '朱辉', '西安电子科技大学出版社', '第一版', 19.00, 1, '怎样利用Java进行网络程序设计');
INSERT INTO `l_book` VALUES (4, '三体', '刘慈欣', '重庆出版社', '第三版', 69.21, 2, '第73届雨果奖最佳长篇小说奖，贼好看');
INSERT INTO `l_book` VALUES (5, '陌上花开', '安意如', '万卷出版公司', '第二版', 21.80, 3, '陌上花开可缓缓归~');

-- ----------------------------
-- Table structure for l_booktype
-- ----------------------------
DROP TABLE IF EXISTS `l_booktype`;
CREATE TABLE `l_booktype`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookTypename` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bookTypeDesc` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of l_booktype
-- ----------------------------
INSERT INTO `l_booktype` VALUES (1, '计算机类', '计算机相关图书等');
INSERT INTO `l_booktype` VALUES (2, '科幻类', '全球科幻小说');
INSERT INTO `l_booktype` VALUES (3, '散文类', '著名散文集');

-- ----------------------------
-- Table structure for l_borrow
-- ----------------------------
DROP TABLE IF EXISTS `l_borrow`;
CREATE TABLE `l_borrow`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `bookname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `borrowname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phonenumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `bookname`(`bookname`) USING BTREE,
  CONSTRAINT `l_borrow_ibfk_1` FOREIGN KEY (`bookname`) REFERENCES `l_book` (`bookName`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of l_borrow
-- ----------------------------
INSERT INTO `l_borrow` VALUES (11, '三体', '张康', '1072447232');

-- ----------------------------
-- Table structure for l_user
-- ----------------------------
DROP TABLE IF EXISTS `l_user`;
CREATE TABLE `l_user`  (
  `id` int(11) NOT NULL,
  `user` varchar(255) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `passwd` varchar(255) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of l_user
-- ----------------------------
INSERT INTO `l_user` VALUES (1, 'admin', '123456');

SET FOREIGN_KEY_CHECKS = 1;
