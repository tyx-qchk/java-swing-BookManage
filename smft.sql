/*
Navicat MySQL Data Transfer

Source Server         : xcw
Source Server Version : 50731
Source Host           : 116.62.158.48:3306
Source Database       : smft

Target Server Type    : MYSQL
Target Server Version : 50731
File Encoding         : 65001

Date: 2020-11-20 09:26:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for Car
-- ----------------------------
DROP TABLE IF EXISTS `Car`;
CREATE TABLE `Car` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT '' COMMENT '车型描述',
  `carName` varchar(255) DEFAULT '' COMMENT '车型名称',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Car
-- ----------------------------
INSERT INTO `Car` VALUES ('1', '轿车汽车标准型', '轿车汽车');
INSERT INTO `Car` VALUES ('2', 'MPV汽车标准型', 'MPV汽车');
INSERT INTO `Car` VALUES ('3', 'SUV汽车标准型', 'SUV汽车');

-- ----------------------------
-- Table structure for CarInfo
-- ----------------------------
DROP TABLE IF EXISTS `CarInfo`;
CREATE TABLE `CarInfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `area` int(11) DEFAULT NULL COMMENT '占地',
  `gold` int(11) DEFAULT NULL COMMENT '价格',
  `repairGold` int(11) DEFAULT NULL COMMENT '维修资金',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of CarInfo
-- ----------------------------
INSERT INTO `CarInfo` VALUES ('1', '6', '2000', '50');
INSERT INTO `CarInfo` VALUES ('2', '7', '3000', '60');
INSERT INTO `CarInfo` VALUES ('3', '5', '4000', '85');

-- ----------------------------
-- Table structure for Information
-- ----------------------------
DROP TABLE IF EXISTS `Information`;
CREATE TABLE `Information` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `informationName` int(11) DEFAULT NULL COMMENT '名称',
  `time` int(11) DEFAULT NULL COMMENT '时间',
  `words` int(11) DEFAULT NULL COMMENT '文字',
  `video` int(11) DEFAULT NULL COMMENT '视频',
  `icon` int(11) DEFAULT NULL COMMENT '图片',
  `status` int(11) DEFAULT NULL COMMENT '类型(0、推荐，1、资讯，2、热点，3、口碑)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Information
-- ----------------------------
INSERT INTO `Information` VALUES ('1', '333333333', '5555555', '8888', '777777', '2222222', '444444');

-- ----------------------------
-- Table structure for Part
-- ----------------------------
DROP TABLE IF EXISTS `Part`;
CREATE TABLE `Part` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `partName` varchar(255) DEFAULT NULL COMMENT '原材料名称',
  `content` int(11) DEFAULT NULL COMMENT '原材料描述',
  `area` int(11) DEFAULT NULL COMMENT '占地',
  `icon` int(11) DEFAULT NULL COMMENT '图标',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Part
-- ----------------------------
INSERT INTO `Part` VALUES ('1', '轿车引擎', null, '2', null);
INSERT INTO `Part` VALUES ('4', '轿车前玻璃', null, '2', null);
INSERT INTO `Part` VALUES ('5', 'MPV前玻璃', null, '2', null);
INSERT INTO `Part` VALUES ('7', '轿车轮胎', null, '1', null);
INSERT INTO `Part` VALUES ('8', 'MPV轮胎', null, '1', null);
INSERT INTO `Part` VALUES ('9', 'SUV轮胎', null, '1', null);
INSERT INTO `Part` VALUES ('10', 'SUV前玻璃', null, '1', null);
INSERT INTO `Part` VALUES ('11', 'MPV引擎', null, '2', null);
INSERT INTO `Part` VALUES ('12', 'SUV引擎', null, '2', null);
INSERT INTO `Part` VALUES ('13', '轿车底盘', null, '3', null);
INSERT INTO `Part` VALUES ('14', 'MPV底盘', null, '3', null);
INSERT INTO `Part` VALUES ('15', 'SUV底盘', null, '3', null);
INSERT INTO `Part` VALUES ('16', '轿车前盖', null, '1', null);
INSERT INTO `Part` VALUES ('17', 'MPV前盖', null, '1', null);
INSERT INTO `Part` VALUES ('18', 'SUV前盖', null, '1', null);
INSERT INTO `Part` VALUES ('19', 'SUV车架', null, '2', null);
INSERT INTO `Part` VALUES ('20', '轿车悬挂', null, '1', null);
INSERT INTO `Part` VALUES ('21', 'MPV悬挂', null, '1', null);
INSERT INTO `Part` VALUES ('22', 'SUV悬挂', null, '1', null);
INSERT INTO `Part` VALUES ('23', '轿车座椅', null, '2', null);
INSERT INTO `Part` VALUES ('24', 'MPV座椅', null, '2', null);
INSERT INTO `Part` VALUES ('25', '轿车方向盘', null, '1', null);
INSERT INTO `Part` VALUES ('26', 'MPV方向盘', null, '1', null);
INSERT INTO `Part` VALUES ('29', '轿车车架', null, '2', null);
INSERT INTO `Part` VALUES ('30', 'MPV车架', null, '2', null);
INSERT INTO `Part` VALUES ('31', '轿车车门', null, '1', null);
INSERT INTO `Part` VALUES ('32', 'MPV车门', null, '1', null);
INSERT INTO `Part` VALUES ('33', 'SUV车门', null, '1', null);
INSERT INTO `Part` VALUES ('34', 'SUV方向盘', null, '1', null);
INSERT INTO `Part` VALUES ('35', '轿车后玻璃', null, '1', null);
INSERT INTO `Part` VALUES ('36', 'MPV后玻璃', null, '1', null);
INSERT INTO `Part` VALUES ('37', 'SUV后玻璃', null, '1', null);
INSERT INTO `Part` VALUES ('38', 'SUV座椅', null, '2', null);

-- ----------------------------
-- Table structure for PassRate
-- ----------------------------
DROP TABLE IF EXISTS `PassRate`;
CREATE TABLE `PassRate` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `passRateName` varchar(255) DEFAULT NULL COMMENT '名称',
  `content` varchar(255) DEFAULT NULL COMMENT '描述',
  `carId` int(11) DEFAULT NULL COMMENT '车辆',
  `rate` int(11) DEFAULT NULL COMMENT '合格率',
  `costTime` int(11) DEFAULT NULL COMMENT '维修时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of PassRate
-- ----------------------------
INSERT INTO `PassRate` VALUES ('1', '轿车汽车维修', '轿车汽车维修', '1', '70', null);
INSERT INTO `PassRate` VALUES ('2', 'MPV汽车维修', 'MPV汽车维修', '2', '60', null);
INSERT INTO `PassRate` VALUES ('3', 'SUV汽车维修', 'SUV汽车维修', '3', '50', null);

-- ----------------------------
-- Table structure for People
-- ----------------------------
DROP TABLE IF EXISTS `People`;
CREATE TABLE `People` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键\r\n主键',
  `peopleName` varchar(255) DEFAULT NULL COMMENT '姓名',
  `icon` varchar(255) DEFAULT NULL COMMENT '头像',
  `status` int(11) DEFAULT NULL COMMENT '工作类型(0、工程师,1、工人,2、技术人员,3、检测人员)',
  `talentMarketId` int(11) DEFAULT NULL COMMENT '人才市场',
  `gold` int(11) DEFAULT NULL COMMENT '报酬',
  `hp` int(11) DEFAULT NULL COMMENT '体力',
  `content` int(11) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of People
-- ----------------------------
INSERT INTO `People` VALUES ('1', '李刚', null, '0', '1', '200', '100', null);
INSERT INTO `People` VALUES ('2', '丁运生', null, '1', '1', '50', '100', null);
INSERT INTO `People` VALUES ('3', '方华高', null, '2', '1', '300', '100', null);
INSERT INTO `People` VALUES ('4', '省均', null, '3', '1', '150', '100', null);
INSERT INTO `People` VALUES ('5', '邹辉', null, '0', '1', '150', '100', null);
INSERT INTO `People` VALUES ('6', '杨文', null, '1', '1', '80', '100', null);
INSERT INTO `People` VALUES ('7', '朱元元', null, '2', '1', '200', '100', null);
INSERT INTO `People` VALUES ('8', '周正发', null, '3', '1', '140', '100', null);
INSERT INTO `People` VALUES ('9', '张伟', null, '0', '1', '300', '100', null);
INSERT INTO `People` VALUES ('10', '周丽', null, '1', '1', '60', '100', null);
INSERT INTO `People` VALUES ('11', '陈敏', null, '2', '1', '140', '100', null);
INSERT INTO `People` VALUES ('12', '陈天云', null, '3', '1', '200', '100', null);
INSERT INTO `People` VALUES ('13', '王百年', null, '0', '1', '300', '100', null);
INSERT INTO `People` VALUES ('14', '王莉', null, '1', '1', '90', '100', null);
INSERT INTO `People` VALUES ('15', '杨保俊', null, '2', '1', '400', '100', null);
INSERT INTO `People` VALUES ('16', '张大伟', null, '3', '1', '120', '100', null);
INSERT INTO `People` VALUES ('17', '徐超', null, '0', '1', '351', '100', null);
INSERT INTO `People` VALUES ('18', '于少明', null, '1', '1', '130', '100', null);
INSERT INTO `People` VALUES ('19', '吴雪平', null, '2', '1', '456', '100', null);
INSERT INTO `People` VALUES ('20', '杨庆春', null, '3', '1', '365', '100', null);
INSERT INTO `People` VALUES ('21', '张旭', null, '0', '1', '458', '100', null);
INSERT INTO `People` VALUES ('22', '崔鹏', null, '1', '1', '123', '100', null);
INSERT INTO `People` VALUES ('23', '范宁', null, '2', '1', '145', '100', null);
INSERT INTO `People` VALUES ('24', '张先龙', null, '3', '1', '457', '100', null);
INSERT INTO `People` VALUES ('25', '邓宁', null, '0', '1', '999', '100', null);
INSERT INTO `People` VALUES ('26', '钟华国', null, '1', '1', '489', '100', null);
INSERT INTO `People` VALUES ('27', '罗梅', null, '2', '1', '888', '100', null);
INSERT INTO `People` VALUES ('28', '王琪', null, '3', '1', '777', '100', null);
INSERT INTO `People` VALUES ('29', '张锋', null, '0', '1', '666', '100', null);
INSERT INTO `People` VALUES ('30', '朱云贵', null, '1', '1', '789', '100', null);
INSERT INTO `People` VALUES ('31', '李冰', null, '2', '1', '479', '100', null);
INSERT INTO `People` VALUES ('32', '李芳', null, '3', '1', '459', '100', null);

-- ----------------------------
-- Table structure for PLStep
-- ----------------------------
DROP TABLE IF EXISTS `PLStep`;
CREATE TABLE `PLStep` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `plStepName` varchar(255) DEFAULT NULL COMMENT '生产环节名称',
  `step` int(11) DEFAULT NULL COMMENT '步骤',
  `power` int(11) DEFAULT NULL COMMENT '耐久',
  `consume` int(11) DEFAULT NULL COMMENT '生产所耗',
  `icon` int(11) DEFAULT NULL COMMENT '图标',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of PLStep
-- ----------------------------

-- ----------------------------
-- Table structure for plStepCost
-- ----------------------------
DROP TABLE IF EXISTS `plStepCost`;
CREATE TABLE `plStepCost` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `plStepId` varchar(255) DEFAULT NULL COMMENT '生产环节',
  `partId` varchar(255) DEFAULT NULL COMMENT '材料',
  `num` int(11) DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of plStepCost
-- ----------------------------

-- ----------------------------
-- Table structure for ProductionLine
-- ----------------------------
DROP TABLE IF EXISTS `ProductionLine`;
CREATE TABLE `ProductionLine` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `productionLineName` varchar(255) DEFAULT NULL COMMENT '生产线名称',
  `content` varchar(255) DEFAULT NULL COMMENT '生产线描述',
  `carId` int(11) DEFAULT NULL COMMENT '车型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ProductionLine
-- ----------------------------
INSERT INTO `ProductionLine` VALUES ('1', '轿车车型生产线', '生产轿车汽车', '1');
INSERT INTO `ProductionLine` VALUES ('2', 'MPV车型生产线', '生产MPV汽车', '2');
INSERT INTO `ProductionLine` VALUES ('3', 'SUV车型生产线', '生产SUV汽车', '3');

-- ----------------------------
-- Table structure for ProductionLineInfo
-- ----------------------------
DROP TABLE IF EXISTS `ProductionLineInfo`;
CREATE TABLE `ProductionLineInfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gold` int(11) DEFAULT NULL COMMENT '价格',
  `stageId` int(11) DEFAULT NULL COMMENT '第一个生产工序',
  `needEnergyNum` int(11) DEFAULT NULL COMMENT '需要能源量',
  `capacity` int(11) DEFAULT NULL COMMENT '容量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ProductionLineInfo
-- ----------------------------
INSERT INTO `ProductionLineInfo` VALUES ('1', '2000', '25', '14', null);
INSERT INTO `ProductionLineInfo` VALUES ('2', '1000', '5', '10', null);
INSERT INTO `ProductionLineInfo` VALUES ('3', '1500', '45', '16', null);

-- ----------------------------
-- Table structure for Stage
-- ----------------------------
DROP TABLE IF EXISTS `Stage`;
CREATE TABLE `Stage` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `stageName` varchar(255) DEFAULT NULL COMMENT '工序名称',
  `content` varchar(255) DEFAULT NULL COMMENT '工序介绍',
  `plStepId` int(11) DEFAULT NULL COMMENT '生产环节ID',
  `nextStageId` int(11) DEFAULT NULL COMMENT '下一个生产工序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Stage
-- ----------------------------
INSERT INTO `Stage` VALUES ('5', 'MPV车型生产环节1', null, '5', '6');
INSERT INTO `Stage` VALUES ('6', 'MPV车型生产环节2', null, '6', '7');
INSERT INTO `Stage` VALUES ('7', 'MPV车型生产环节3', null, '7', '8');
INSERT INTO `Stage` VALUES ('8', 'MPV车型生产环节4', null, '8', '9');
INSERT INTO `Stage` VALUES ('9', 'MPV车型生产环节5', null, '9', '10');
INSERT INTO `Stage` VALUES ('10', 'MPV车型生产环节6', null, '10', '11');
INSERT INTO `Stage` VALUES ('11', 'MPV车型生产环节7', null, '12', '12');
INSERT INTO `Stage` VALUES ('12', 'MPV车型生产环节8', null, '11', '13');
INSERT INTO `Stage` VALUES ('13', 'MPV车型生产环节9', null, '13', '14');
INSERT INTO `Stage` VALUES ('14', 'MPV车型生产环节10', null, '14', '15');
INSERT INTO `Stage` VALUES ('15', 'MPV车型生产环节11', null, '15', '16');
INSERT INTO `Stage` VALUES ('16', 'MPV车型生产环节12', null, '16', '17');
INSERT INTO `Stage` VALUES ('17', 'MPV车型生产环节13', null, '17', '18');
INSERT INTO `Stage` VALUES ('18', 'MPV车型生产环节14', null, '18', '19');
INSERT INTO `Stage` VALUES ('19', 'MPV车型生产环节15', null, '19', '20');
INSERT INTO `Stage` VALUES ('20', 'MPV车型生产环节16', null, '20', '21');
INSERT INTO `Stage` VALUES ('21', 'MPV车型生产环节17', null, '21', '22');
INSERT INTO `Stage` VALUES ('22', 'MPV车型生产环节18', null, '22', '23');
INSERT INTO `Stage` VALUES ('23', 'MPV车型生产环节19', null, '23', '24');
INSERT INTO `Stage` VALUES ('24', 'MPV车型生产环节20', null, '24', '-1');
INSERT INTO `Stage` VALUES ('25', '轿车车型生产环节1', null, '25', '26');
INSERT INTO `Stage` VALUES ('26', '轿车车型生产环节2', null, '26', '27');
INSERT INTO `Stage` VALUES ('27', '轿车车型生产环节3', null, '27', '28');
INSERT INTO `Stage` VALUES ('28', '轿车车型生产环节4', null, '28', '29');
INSERT INTO `Stage` VALUES ('29', '轿车车型生产环节5', null, '29', '30');
INSERT INTO `Stage` VALUES ('30', '轿车车型生产环节6', null, '30', '31');
INSERT INTO `Stage` VALUES ('31', '轿车车型生产环节7', null, '32', '32');
INSERT INTO `Stage` VALUES ('32', '轿车车型生产环节8', null, '31', '33');
INSERT INTO `Stage` VALUES ('33', '轿车车型生产环节9', null, '33', '34');
INSERT INTO `Stage` VALUES ('34', '轿车车型生产环节10', null, '34', '35');
INSERT INTO `Stage` VALUES ('35', '轿车车型生产环节11', null, '35', '36');
INSERT INTO `Stage` VALUES ('36', '轿车车型生产环节12', null, '36', '37');
INSERT INTO `Stage` VALUES ('37', '轿车车型生产环节13', null, '37', '38');
INSERT INTO `Stage` VALUES ('38', '轿车车型生产环节14', null, '38', '39');
INSERT INTO `Stage` VALUES ('39', '轿车车型生产环节15', null, '39', '40');
INSERT INTO `Stage` VALUES ('40', '轿车车型生产环节16', null, '40', '41');
INSERT INTO `Stage` VALUES ('41', '轿车车型生产环节17', null, '41', '42');
INSERT INTO `Stage` VALUES ('42', '轿车车型生产环节18', null, '42', '43');
INSERT INTO `Stage` VALUES ('43', '轿车车型生产环节19', null, '43', '44');
INSERT INTO `Stage` VALUES ('44', '轿车车型生产环节20', null, '44', '-1');
INSERT INTO `Stage` VALUES ('45', 'SUV车型生产环节1', null, '45', '46');
INSERT INTO `Stage` VALUES ('46', 'SUV车型生产环节2', null, '46', '47');
INSERT INTO `Stage` VALUES ('47', 'SUV车型生产环节3', null, '47', '48');
INSERT INTO `Stage` VALUES ('48', 'SUV车型生产环节4', null, '48', '49');
INSERT INTO `Stage` VALUES ('49', 'SUV车型生产环节5', null, '49', '50');
INSERT INTO `Stage` VALUES ('50', 'SUV车型生产环节6', null, '50', '51');
INSERT INTO `Stage` VALUES ('51', 'SUV车型生产环节7', null, '52', '52');
INSERT INTO `Stage` VALUES ('52', 'SUV车型生产环节8', null, '51', '53');
INSERT INTO `Stage` VALUES ('53', 'SUV车型生产环节9', null, '53', '54');
INSERT INTO `Stage` VALUES ('54', 'SUV车型生产环节10', null, '54', '55');
INSERT INTO `Stage` VALUES ('55', 'SUV车型生产环节11', null, '55', '56');
INSERT INTO `Stage` VALUES ('56', 'SUV车型生产环节12', null, '56', '57');
INSERT INTO `Stage` VALUES ('57', 'SUV车型生产环节13', null, '57', '58');
INSERT INTO `Stage` VALUES ('58', 'SUV车型生产环节14', null, '58', '59');
INSERT INTO `Stage` VALUES ('59', 'SUV车型生产环节15', null, '59', '60');
INSERT INTO `Stage` VALUES ('60', 'SUV车型生产环节16', null, '60', '61');
INSERT INTO `Stage` VALUES ('61', 'SUV车型生产环节17', null, '61', '62');
INSERT INTO `Stage` VALUES ('62', 'SUV车型生产环节18', null, '62', '63');
INSERT INTO `Stage` VALUES ('63', 'SUV车型生产环节19', null, '63', '64');
INSERT INTO `Stage` VALUES ('64', 'SUV车型生产环节20', null, '64', '-1');

-- ----------------------------
-- Table structure for Suppier
-- ----------------------------
DROP TABLE IF EXISTS `Suppier`;
CREATE TABLE `Suppier` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `suppierName` varchar(255) DEFAULT NULL COMMENT '供货商名称',
  `content` int(11) DEFAULT NULL COMMENT '供货商描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Suppier
-- ----------------------------
INSERT INTO `Suppier` VALUES ('1', '新星汽车配件', null);
INSERT INTO `Suppier` VALUES ('2', '枫叶汽车配件', null);
INSERT INTO `Suppier` VALUES ('5', '天辉汽车配件', null);
INSERT INTO `Suppier` VALUES ('6', '细末汽车配件', null);

-- ----------------------------
-- Table structure for TalentMarket
-- ----------------------------
DROP TABLE IF EXISTS `TalentMarket`;
CREATE TABLE `TalentMarket` (
  `id` int(11) NOT NULL COMMENT '主键',
  `talentMarketName` varchar(255) DEFAULT NULL COMMENT '人才市场名称',
  `content` int(11) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of TalentMarket
-- ----------------------------
INSERT INTO `TalentMarket` VALUES ('1', '汽车员工招聘中心', null);

-- ----------------------------
-- Table structure for UserAppointment
-- ----------------------------
DROP TABLE IF EXISTS `UserAppointment`;
CREATE TABLE `UserAppointment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userWorkId` int(11) DEFAULT NULL COMMENT '学生工厂(0、红色，1、蓝色，2、绿色)',
  `userAppointmentName` int(11) DEFAULT NULL COMMENT '订单名称',
  `content` int(11) DEFAULT NULL COMMENT '订单描述',
  `type` int(11) DEFAULT NULL COMMENT '(0、已下单，1、生产中，2、完成)',
  `carId` int(11) DEFAULT NULL COMMENT '车型',
  `time` int(11) DEFAULT NULL COMMENT '交付时间',
  `num` int(11) DEFAULT NULL COMMENT '数量',
  `gold` int(11) DEFAULT NULL COMMENT '收益',
  `engine` int(11) DEFAULT NULL COMMENT '发动机排量(0、1.0，1、1.5，2、2.0，3、2.5，4、3.0，5、4.0)',
  `speed` int(11) DEFAULT NULL COMMENT '变速箱(0、自动，1、手动)',
  `wheel` int(11) DEFAULT NULL COMMENT '轮毂(0、烤漆，1、电镀)',
  `control` int(11) DEFAULT NULL COMMENT '中控(0、低配，1、高配)',
  `brake` int(11) DEFAULT NULL COMMENT '刹车(0、，鼓式制动器，1、盘式制动器)',
  `hang` int(11) DEFAULT NULL COMMENT '悬挂(1、独立悬挂系统，2、主动悬挂系统，3、横臂式悬挂系统，4、纵臂式悬\r\n挂系统，5、烛式悬挂系统，6、多连杆式悬挂系统，7、麦弗逊式悬挂系统)\r\n',
  `color` int(11) DEFAULT NULL COMMENT '外观装饰(0、红色，1、蓝色，2、绿色)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of UserAppointment
-- ----------------------------

-- ----------------------------
-- Table structure for UserInPriceLog
-- ----------------------------
DROP TABLE IF EXISTS `UserInPriceLog`;
CREATE TABLE `UserInPriceLog` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userWorkId` int(11) DEFAULT NULL COMMENT '学生工厂',
  `price` int(11) DEFAULT NULL COMMENT '金币',
  `endPrice` int(11) DEFAULT NULL COMMENT '剩余金币',
  `time` varchar(255) DEFAULT NULL COMMENT '时间',
  `type` int(11) DEFAULT NULL COMMENT '类型(0、原材料,1、人员,2、生产线,3、维修生产环节,4、维修车辆,5、售出)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of UserInPriceLog
-- ----------------------------
INSERT INTO `UserInPriceLog` VALUES ('1', '6666', '22222', '111', '44444', '5555');
INSERT INTO `UserInPriceLog` VALUES ('2', '1', '200', '5000', '10', '0');
INSERT INTO `UserInPriceLog` VALUES ('4', '0', '0', '0', '', '0');

-- ----------------------------
-- Table structure for UserNormalCarLog
-- ----------------------------
DROP TABLE IF EXISTS `UserNormalCarLog`;
CREATE TABLE `UserNormalCarLog` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userWorkId` int(11) DEFAULT NULL COMMENT '学生工厂',
  `userProductionLineId` int(11) DEFAULT NULL COMMENT '学生生产线',
  `carId` int(11) DEFAULT NULL COMMENT '汽车',
  `time` int(11) DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of UserNormalCarLog
-- ----------------------------

-- ----------------------------
-- Table structure for UserNormalCarStore
-- ----------------------------
DROP TABLE IF EXISTS `UserNormalCarStore`;
CREATE TABLE `UserNormalCarStore` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userWorkId` int(11) DEFAULT NULL COMMENT '学生工厂',
  `userProductionLineId` int(11) DEFAULT NULL COMMENT '学生生产线',
  `carId` int(11) DEFAULT NULL COMMENT '汽车',
  `num` int(11) DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of UserNormalCarStore
-- ----------------------------
INSERT INTO `UserNormalCarStore` VALUES ('1943', '1', '2169', '2', '1');

-- ----------------------------
-- Table structure for UserOutPriceLog
-- ----------------------------
DROP TABLE IF EXISTS `UserOutPriceLog`;
CREATE TABLE `UserOutPriceLog` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userWorkId` int(11) DEFAULT NULL COMMENT '学生工厂',
  `price` int(11) DEFAULT NULL COMMENT '金币',
  `endPrice` int(11) DEFAULT NULL COMMENT '剩余金币',
  `time` varchar(255) DEFAULT NULL COMMENT '时间',
  `type` int(11) DEFAULT NULL COMMENT '类型(0、原材料,1、人员,2、生产线,3、维修生产环节,4、维修车辆,5、售出)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of UserOutPriceLog
-- ----------------------------
INSERT INTO `UserOutPriceLog` VALUES ('1', '6666666', '333333', '2222', '444444', '5555');

-- ----------------------------
-- Table structure for UserPartLog
-- ----------------------------
DROP TABLE IF EXISTS `UserPartLog`;
CREATE TABLE `UserPartLog` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userWorkId` int(11) DEFAULT NULL COMMENT '学生工厂',
  `suppierListId` int(11) DEFAULT NULL COMMENT '供货列表',
  `num` int(11) DEFAULT NULL COMMENT '数量',
  `time` varchar(255) DEFAULT NULL COMMENT '购买时间',
  `gold` int(11) DEFAULT NULL COMMENT '价格',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of UserPartLog
-- ----------------------------
INSERT INTO `UserPartLog` VALUES ('1', '66666', '444444', '33333', '55555', '2222');

-- ----------------------------
-- Table structure for UserPartPurchaseLog
-- ----------------------------
DROP TABLE IF EXISTS `UserPartPurchaseLog`;
CREATE TABLE `UserPartPurchaseLog` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userWorkId` int(11) DEFAULT NULL COMMENT '学生工厂',
  `userProductionLineId` int(11) DEFAULT NULL COMMENT '学生生产线',
  `userStageId` int(11) DEFAULT NULL COMMENT '生产工序',
  `PartId` int(11) DEFAULT NULL COMMENT '原材料',
  `num` int(11) DEFAULT NULL COMMENT '数量',
  `time` varchar(255) DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of UserPartPurchaseLog
-- ----------------------------
INSERT INTO `UserPartPurchaseLog` VALUES ('1', '777', '555555', '666666', '3333', '2222', '4444');

-- ----------------------------
-- Table structure for UserParts
-- ----------------------------
DROP TABLE IF EXISTS `UserParts`;
CREATE TABLE `UserParts` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userWorkId` int(11) DEFAULT NULL COMMENT '学生工厂',
  `userProductionLineId` int(11) DEFAULT NULL COMMENT '学生生产线',
  `partId` int(11) DEFAULT NULL COMMENT '原材料',
  `num` int(11) DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of UserParts
-- ----------------------------
INSERT INTO `UserParts` VALUES ('1', '666666', '4444', '33333', '22222');

-- ----------------------------
-- Table structure for UserPartStore
-- ----------------------------
DROP TABLE IF EXISTS `UserPartStore`;
CREATE TABLE `UserPartStore` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userWorkId` int(11) DEFAULT NULL COMMENT '学生工厂',
  `partId` int(11) DEFAULT NULL COMMENT '原材料',
  `userProductionLineId` int(11) DEFAULT NULL COMMENT '学生生产线',
  `num` int(11) DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of UserPartStore
-- ----------------------------
INSERT INTO `UserPartStore` VALUES ('2', '66666', '44', '555555', '3333');

-- ----------------------------
-- Table structure for UserPeople
-- ----------------------------
DROP TABLE IF EXISTS `UserPeople`;
CREATE TABLE `UserPeople` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userWorkId` int(11) DEFAULT NULL COMMENT '学生工厂',
  `power` int(11) DEFAULT NULL COMMENT '体力',
  `peopleId` int(11) DEFAULT NULL COMMENT '人员',
  `userProductionLineId` int(11) DEFAULT NULL COMMENT '学生生产线',
  `workPostId` int(11) DEFAULT NULL COMMENT '岗位',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2369 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of UserPeople
-- ----------------------------
INSERT INTO `UserPeople` VALUES ('2365', '1', '100', '16', '2171', null);
INSERT INTO `UserPeople` VALUES ('2366', '1', '100', '15', '2171', null);
INSERT INTO `UserPeople` VALUES ('2367', '1', '50', '17', '2171', null);
INSERT INTO `UserPeople` VALUES ('2368', '1', '100', '22', '2171', null);

-- ----------------------------
-- Table structure for UserPeopleLog
-- ----------------------------
DROP TABLE IF EXISTS `UserPeopleLog`;
CREATE TABLE `UserPeopleLog` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userWorkId` int(11) DEFAULT NULL COMMENT '学生工厂',
  `userPeopleId` int(11) DEFAULT NULL COMMENT '学生员工',
  `time` int(11) DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of UserPeopleLog
-- ----------------------------
INSERT INTO `UserPeopleLog` VALUES ('1', '4444444', '33333333', '22222222');

-- ----------------------------
-- Table structure for UserPlStep
-- ----------------------------
DROP TABLE IF EXISTS `UserPlStep`;
CREATE TABLE `UserPlStep` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userWorkId` int(11) DEFAULT NULL COMMENT '学生工厂',
  `userProductionLineId` int(11) DEFAULT NULL COMMENT '学生生产线',
  `nextUserPlStepId` int(11) DEFAULT NULL COMMENT '下一个学生生产环节',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of UserPlStep
-- ----------------------------
INSERT INTO `UserPlStep` VALUES ('1', '44444', '33333', '22222');
INSERT INTO `UserPlStep` VALUES ('2', '5555', '4444', '3333');

-- ----------------------------
-- Table structure for UserPlStepInfo
-- ----------------------------
DROP TABLE IF EXISTS `UserPlStepInfo`;
CREATE TABLE `UserPlStepInfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `plStepName` int(11) DEFAULT NULL COMMENT '生产环节名称',
  `stageId` int(11) DEFAULT NULL COMMENT '生产工序',
  `costTime` int(11) DEFAULT NULL COMMENT '耗时',
  `step` int(11) DEFAULT NULL COMMENT '步骤',
  `power` int(11) DEFAULT NULL COMMENT '耐久',
  `consume` int(11) DEFAULT NULL COMMENT '生产所耗',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of UserPlStepInfo
-- ----------------------------
INSERT INTO `UserPlStepInfo` VALUES ('2', '55555', '777777', '3333', '88888', '6666', '44444');

-- ----------------------------
-- Table structure for UserProductionLine
-- ----------------------------
DROP TABLE IF EXISTS `UserProductionLine`;
CREATE TABLE `UserProductionLine` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userWorkId` int(11) DEFAULT NULL COMMENT '学生工厂',
  `stageId` int(11) DEFAULT NULL COMMENT '当前生产工序',
  `productionLineId` int(11) DEFAULT NULL COMMENT '生产线',
  `type` int(11) DEFAULT NULL COMMENT '状态(0、建设中,1、缺原材料,2、生产中,3、库存已满)',
  `position` int(11) DEFAULT NULL COMMENT '位置(0、位置1,1、位置2,2、位置3,3、位置4)',
  `isAI` int(11) DEFAULT NULL COMMENT '是否AI(0、否,1、是)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2170 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of UserProductionLine
-- ----------------------------
INSERT INTO `UserProductionLine` VALUES ('1', '7777', '55555', '44444', '66666', '33333', '22222');
INSERT INTO `UserProductionLine` VALUES ('2169', '1', '5', '2', null, '0', null);

-- ----------------------------
-- Table structure for UserQuestion
-- ----------------------------
DROP TABLE IF EXISTS `UserQuestion`;
CREATE TABLE `UserQuestion` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userWorkId` int(11) DEFAULT NULL COMMENT '学生工厂',
  `carId` int(11) DEFAULT NULL COMMENT '汽车',
  `userProductionLineId` int(11) DEFAULT NULL COMMENT '学生生产线',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of UserQuestion
-- ----------------------------

-- ----------------------------
-- Table structure for UserQuestionLog
-- ----------------------------
DROP TABLE IF EXISTS `UserQuestionLog`;
CREATE TABLE `UserQuestionLog` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userWorkId` int(11) DEFAULT NULL COMMENT '学生工厂',
  `userProductionLineId` int(11) DEFAULT NULL COMMENT '学生生产线',
  `userQuestionId` int(11) DEFAULT NULL COMMENT '学生问题车辆',
  `time` int(11) DEFAULT NULL COMMENT '维修时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of UserQuestionLog
-- ----------------------------

-- ----------------------------
-- Table structure for UserRepairCarLog
-- ----------------------------
DROP TABLE IF EXISTS `UserRepairCarLog`;
CREATE TABLE `UserRepairCarLog` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userWorkId` int(11) DEFAULT NULL COMMENT '学生工厂',
  `userProductionLineId` int(11) DEFAULT NULL COMMENT '学生生产线',
  `carId` int(11) DEFAULT NULL COMMENT '汽车',
  `time` int(11) DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of UserRepairCarLog
-- ----------------------------
INSERT INTO `UserRepairCarLog` VALUES ('1', '963147', '147852', '123456', '654321');
INSERT INTO `UserRepairCarLog` VALUES ('3', '0', '0', '0', '0');

-- ----------------------------
-- Table structure for UserRepairCarStore
-- ----------------------------
DROP TABLE IF EXISTS `UserRepairCarStore`;
CREATE TABLE `UserRepairCarStore` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userWorkId` int(11) DEFAULT NULL COMMENT '学生工厂',
  `userProductionLineId` int(11) DEFAULT NULL COMMENT '学生生产线',
  `carId` int(11) DEFAULT NULL COMMENT '汽车',
  `num` int(11) DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of UserRepairCarStore
-- ----------------------------

-- ----------------------------
-- Table structure for UserSellOutLog
-- ----------------------------
DROP TABLE IF EXISTS `UserSellOutLog`;
CREATE TABLE `UserSellOutLog` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userWorkId` int(11) DEFAULT NULL COMMENT '学生工厂',
  `carId` int(11) DEFAULT NULL COMMENT ' 汽车',
  `gold` int(11) DEFAULT NULL COMMENT '价格',
  `time` int(11) DEFAULT NULL COMMENT '卖出时间',
  `num` int(11) DEFAULT NULL COMMENT '卖出数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of UserSellOutLog
-- ----------------------------

-- ----------------------------
-- Table structure for UserWork
-- ----------------------------
DROP TABLE IF EXISTS `UserWork`;
CREATE TABLE `UserWork` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `loginName` int(11) DEFAULT NULL COMMENT '登录名',
  `nickName` varchar(255) DEFAULT NULL COMMENT '昵称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of UserWork
-- ----------------------------
INSERT INTO `UserWork` VALUES ('1', '11', 'xcw22');

-- ----------------------------
-- Table structure for UserWorkEnvironmental
-- ----------------------------
DROP TABLE IF EXISTS `UserWorkEnvironmental`;
CREATE TABLE `UserWorkEnvironmental` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `day` varchar(255) DEFAULT NULL COMMENT '当前天数',
  `lightSwitch` varchar(255) DEFAULT NULL COMMENT '灯光开启(0、关,1、开)',
  `acOnOff` varchar(255) DEFAULT NULL COMMENT '空调开关(0,关,1,冷风,2,暖风)',
  `beam` varchar(255) DEFAULT NULL COMMENT '光照',
  `workshopTemp` varchar(255) DEFAULT NULL COMMENT '车间温度',
  `outTemp` varchar(255) DEFAULT NULL COMMENT '室外温度',
  `power` varchar(255) DEFAULT NULL COMMENT '电力供应',
  `powerConsume` varchar(255) DEFAULT NULL COMMENT '电力消耗',
  `time` varchar(255) DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of UserWorkEnvironmental
-- ----------------------------
INSERT INTO `UserWorkEnvironmental` VALUES ('1', 'string', 'string', 'stringacOnOff', 'string', 'string', 'string', 'string', 'stringpowerConsume', 'string');

-- ----------------------------
-- Table structure for UserWorkEnvironmentalLog
-- ----------------------------
DROP TABLE IF EXISTS `UserWorkEnvironmentalLog`;
CREATE TABLE `UserWorkEnvironmentalLog` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userWorkId` varchar(255) DEFAULT NULL COMMENT '学生工厂',
  `day` varchar(255) DEFAULT NULL COMMENT '当前天数',
  `lightSwitch` varchar(255) DEFAULT NULL COMMENT '灯光开启(0,关,1,开)',
  `acOnOff` varchar(255) DEFAULT NULL COMMENT '空调开关(0,关,1,冷风,2,暖风)',
  `beam` varchar(255) DEFAULT NULL COMMENT '光照',
  `workshopTemp` varchar(255) DEFAULT NULL COMMENT '车间温度',
  `outTemp` varchar(255) DEFAULT NULL COMMENT '室外温度',
  `power` varchar(255) DEFAULT NULL COMMENT '电力供应',
  `powerConsume` varchar(255) DEFAULT NULL COMMENT '电力消耗',
  `time` varchar(255) DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of UserWorkEnvironmentalLog
-- ----------------------------

-- ----------------------------
-- Table structure for UserWorkInfo
-- ----------------------------
DROP TABLE IF EXISTS `UserWorkInfo`;
CREATE TABLE `UserWorkInfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `partCapacity` int(11) DEFAULT NULL COMMENT '原材料容量',
  `carCapacity` int(11) DEFAULT NULL COMMENT '汽车容量',
  `price` int(11) DEFAULT NULL COMMENT '金币',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of UserWorkInfo
-- ----------------------------
INSERT INTO `UserWorkInfo` VALUES ('1', '11', '222', '9999');

-- ----------------------------
-- Table structure for WorkPost
-- ----------------------------
DROP TABLE IF EXISTS `WorkPost`;
CREATE TABLE `WorkPost` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `workPostName` varchar(255) DEFAULT NULL COMMENT '岗位名称',
  `productionLineInfold` int(11) DEFAULT NULL COMMENT '生产线',
  `status` int(11) DEFAULT NULL COMMENT '工作类型(0.工程师，1.工人，2.技术人员)',
  `consume` int(11) DEFAULT NULL COMMENT '消耗体力',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of WorkPost
-- ----------------------------
INSERT INTO `WorkPost` VALUES ('1', '轿车汽车工程师', '1', '0', '2');
INSERT INTO `WorkPost` VALUES ('2', '轿车汽车工人', '1', '1', '2');
INSERT INTO `WorkPost` VALUES ('3', '轿车汽车技术人员', '1', '2', '2');
INSERT INTO `WorkPost` VALUES ('4', '轿车汽车检测员', '1', '3', '2');
INSERT INTO `WorkPost` VALUES ('5', 'MPV汽车工程师', '2', '0', '2');
INSERT INTO `WorkPost` VALUES ('6', 'MPV汽车工人', '2', '1', '2');
INSERT INTO `WorkPost` VALUES ('7', 'MPV汽车技术人员', '2', '2', '2');
INSERT INTO `WorkPost` VALUES ('8', 'MPV汽车检测人员', '2', '3', '2');
INSERT INTO `WorkPost` VALUES ('9', 'SUV汽车工程师', '3', '0', '2');
INSERT INTO `WorkPost` VALUES ('10', 'SUV汽车工人', '3', '1', '2');
INSERT INTO `WorkPost` VALUES ('11', 'SUV汽车技术人员', '3', '2', '2');
INSERT INTO `WorkPost` VALUES ('12', 'SUV汽车质检员', '3', '3', '2');
