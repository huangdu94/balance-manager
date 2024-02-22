-- 用户表
CREATE TABLE IF NOT EXISTS users (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  name TEXT NOT NULL
);

-- 额度类型表
CREATE TABLE IF NOT EXISTS limit_types (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  name TEXT NOT NULL
);


-- 额度表
CREATE TABLE IF NOT EXISTS limits (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  user_id INTEGER,
  limit_type_id INTEGER,
  amount REAL
);

-- 初始用户数据
INSERT INTO users (name) VALUES ('alice'), ('bob'), ('charlie');
-- 初始额度类型数据
-- 信用卡/贷款/透支/投资/购物
INSERT INTO limit_types (name) VALUES ('credit'), ('loan'), ('overdraft'), ('investment'), ('spending');