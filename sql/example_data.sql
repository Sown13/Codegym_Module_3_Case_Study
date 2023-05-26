use case_study_m3;
insert into users values
(default, 'son94', '123456', 'Nguyen Hai Son', 'Ha Nam', 'son@gmail.com'),
(default, 'nam95', '123456', 'Nguyen Hoai Nam', 'Ha Noi', 'nam@gmail.com'),
(default, 'adua2001', '123456', 'Giang A Dua', 'Bac Ninh', 'adua@gmail.com'),
(default, 'tuuyen2001', '123456', 'Dinh Thi Tu Uyen', 'Ha Noi', 'uyen@gmail.com'),
(default, 'tuan97', '123456', 'PHam Minh Tuan', 'Ha Noi', 'tuan@gmail.com'),
(default, 'hung97', '123456', 'Nguyen Nhu Hung', 'Nam Dinh', 'hung@gmail.com'),
(default, 'congnghien97', '123456', 'Pham Minh Cong', 'Bac Ninh', 'cong@gmail.com'),
(default, 'hai96', '987654321', 'Ngo Hoang Hai', 'Ha Noi', 'hai@gmail.com'),
(default, 'hai00', '234567','Do Trong Hai', 'Bac Ninh', 'haido@gmail.com'),
(default, 'hieu96', '3445778', 'Dang Manh Hieu', 'Nam Dinh', 'hieu@gmail.com');

insert into songs(s_id, song_name, author, upload_date, url, listening_frequency, label, u_id) values
(default, 'Khong yeu', 'sonson',default, 'abc', 1, 'nhac tre', 1),
(default, 'Yeu khong', 'sonson',default, 'abc', 1, 'nhac tre', 1),
(default, 'Em la ai', 'sonson',default, 'abc', 1, 'pop', 1),
(default, 'Anh la ai', 'sonson',default, 'abc', 1, 'nhac gia', 2),
(default, 'Day la dau', 'sonson',default, 'abc', 1, 'nhac vang', 2),
(default, 'Em o dau', 'sonson',default, 'abc', 1, 'pop', 3),
(default, 'Anh o dau', 'sonson',default, 'abc', 1, 'jar', 3),
(default, 'Lan dau gap go', 'sonson',default, 'abc', 1, 'pop', 4),
(default, 'Khong yeu', 'sonson',default, 'abc', 1, 'nhac tre', 5),
(default, 'Toi la ai', 'sonson', default, 'abc', 1, 'nhac ma', 6),
(default, 'Day la dau', 'sonson', default, 'abc', 1, 'rock', 4),
(default, 'Toi la dau', 'sonson', default, 'abc', 1, 'nhac tre', 7),
(default, 'Day la ai', 'sonson', default, 'abc', 1, 'pop', 5),
(default, 'Chau len ba', 'sonson', default, 'abc', 1, 'nhac thieu nhi', 7),
(default, 'Chau len bon', 'sonson', default, 'abc', 1, 'nhac thieu nhi', 8),
(default, 'Chau len nam', 'sonson', default, 'abc', 1, 'nhac vang', 9),
(default, 'Chau len sau', 'sonson', default, 'abc', 1, 'nhac buon', 10),
(default, 'Chau len bay', 'sonson', default, 'abc', 1, 'jar', 10),
(default, 'Chau len tam', 'sonson', default, 'abc', 1, 'pop', 9),
(default, 'Chau len chin', 'sonson', default, 'abc', 1, 'classical', 7),
(default, 'Chau len muoi', 'sonson', default, 'abc', 1, 'nhac tre', 8);
insert into playlist values
(default, 'Ua thich cua Son', default, 1,'nhac tre'),
(default, 'Son hay nghe', default, 1,'nhac vang'),
(default, 'Ua thich cua Nam', default, 2,'rock'),
(default, 'Ua thich cua Dua', default, 3,'jar'),
(default, 'Ua thich cua Uyen', default, 4,'pop');


insert into playlist_detail values
(default, 1, 1),
(default, 2, 1),
(default, 4, 1),
(default, 2, 2),
(default, 5, 2),
(default, 9, 2),
(default, 1, 2),
(default, 4, 3),
(default, 3, 3),
(default, 6, 3),
(default, 7, 3),
(default, 8, 1),
(default, 9, 4),
(default, 3, 4),
(default, 2, 4),
(default, 4, 4),
(default, 5, 4);







