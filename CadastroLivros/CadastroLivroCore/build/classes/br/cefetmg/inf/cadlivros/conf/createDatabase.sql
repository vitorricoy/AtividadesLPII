CREATE TABLE IF NOT EXISTS Livro (
	nome text,
	autor text,
	isbn bigint,
	volume int,
	data date,
	editora text,
	numpaginas int,
	PRIMARY KEY( isbn )
);