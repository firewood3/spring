drop table TBL_NOTICE if exists;

CREATE TABLE TBL_NOTICE (
  id integer NOT NULL,
  title varchar(100) NOT NULL,
  content varchar(500) NOT NULL
);