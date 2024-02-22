-- 项目启动时该脚本自动执行，无需手动执行
-- 用户表
DROP TABLE IF EXISTS users;
CREATE TABLE users (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  name TEXT NOT NULL
);
INSERT INTO users (name) VALUES ('alice'), ('bob'), ('charlie');

-- 额度类型表
DROP TABLE IF EXISTS limit_types;
CREATE TABLE limit_types (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  name TEXT NOT NULL
);
-- 信用卡/贷款/透支/投资/购物
INSERT INTO limit_types (name) VALUES ('credit'), ('loan'), ('overdraft'), ('investment'), ('spending');

-- 额度表
CREATE TABLE IF NOT EXISTS limits (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  user_id INTEGER,
  limit_type_id INTEGER,
  amount REAL
);