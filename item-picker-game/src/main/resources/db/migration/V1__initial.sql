CREATE TABLE items
(
    id             uuid default gen_random_uuid() not null
        constraint items__pkey primary key,
    creation_date    timestamp with time zone default now(),
    item_title     varchar(90),
    description    text
);



CREATE TABLE item_votes
(
    id             uuid default gen_random_uuid() not null
        constraint items_votes__pkey primary key,
    creation_date    timestamp with time zone default now(),
    item_id        uuid                           not null
);

