CREATE TABLE IF NOT EXISTS Livro (
	nome text,
	autor text,
	isbn bigint,
	volume int,
	data date,
	editora text,
	numpags int,
	PRIMARY KEY( isbn )
);