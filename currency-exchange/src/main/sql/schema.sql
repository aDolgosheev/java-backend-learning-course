-- Создание базы данных
CREATE DATABASE currency_exchange;

-- Подключаемся к созданной базе данных
\c currency_exchange;

-- Создание таблицы currencies
CREATE TABLE currencies (
                            id SERIAL PRIMARY KEY,
                            code VARCHAR(3) NOT NULL UNIQUE,
                            full_name VARCHAR(255) NOT NULL,
                            sign VARCHAR(5) NOT NULL
);

-- Создание таблицы exchange_rates
CREATE TABLE exchange_rates (
                                id SERIAL PRIMARY KEY,
                                base_currency_id INTEGER NOT NULL,
                                target_currency_id INTEGER NOT NULL,
                                rate DECIMAL(10,6) NOT NULL,
                                FOREIGN KEY (base_currency_id) REFERENCES currencies(id),
                                FOREIGN KEY (target_currency_id) REFERENCES currencies(id),
                                UNIQUE (base_currency_id, target_currency_id)
);

-- Добавление индексов для оптимизации
CREATE INDEX idx_currency_code ON currencies(code);
CREATE INDEX idx_exchange_rates_pair ON exchange_rates(base_currency_id, target_currency_id);

-- Вставка примерных данных для тестирования
INSERT INTO currencies (code, full_name, sign) VALUES
                                                   ('USD', 'United States Dollar', '$'),
                                                   ('EUR', 'Euro', '€'),
                                                   ('RUB', 'Russian Ruble', '₽'),
                                                   ('GBP', 'British Pound', '£'),
                                                   ('JPY', 'Japanese Yen', '¥');

-- Вставка примерных обменных курсов
INSERT INTO exchange_rates (base_currency_id, target_currency_id, rate) VALUES
                                                                            (1, 2, 0.85),      -- USD to EUR
                                                                            (1, 3, 75.50),     -- USD to RUB
                                                                            (1, 4, 0.73),      -- USD to GBP
                                                                            (1, 5, 110.0),     -- USD to JPY
                                                                            (2, 3, 89.10),     -- EUR to RUB
                                                                            (2, 4, 0.86),      -- EUR to GBP
                                                                            (2, 5, 129.50);    -- EUR to JPY

-- Проверка созданных таблиц
SELECT * FROM currencies;
SELECT * FROM exchange_rates;