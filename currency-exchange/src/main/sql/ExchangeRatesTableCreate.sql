create schema if not exists postgres;

create table if not exists postgres.exchange_rates
(
    ID               serial primary key,
    BaseCurrencyId   int     not null references postgres.currencies (ID),
    TargetCurrencyId int     not null references postgres.currencies (ID),
    Rate             decimal not null
);

insert into postgres.exchange_rates (basecurrencyid, targetcurrencyid, rate)
values (1, 2, 0.94);
insert into postgres.exchange_rates (basecurrencyid, targetcurrencyid, rate)
values (1, 3, 63.75);
insert into postgres.exchange_rates (basecurrencyid, targetcurrencyid, rate)
values (1, 4, 36.95);
insert into postgres.exchange_rates (basecurrencyid, targetcurrencyid, rate)
values (1, 5, 469.88);
insert into postgres.exchange_rates (basecurrencyid, targetcurrencyid, rate)
values (1, 6, 0.81);