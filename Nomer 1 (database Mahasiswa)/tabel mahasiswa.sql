CREATE TABLE mahasiswa (
    id SERIAL PRIMARY KEY,
    nama VARCHAR(255) NOT NULL,
    semester INT,
	tahun INT,
    jurusan VARCHAR(255),
    gender VARCHAR(10)
);