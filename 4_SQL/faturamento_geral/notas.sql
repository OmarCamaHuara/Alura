-- (aleatorio() * (MAX-MIN+1) + MIN)
-- MIN 15, MAX 50

select floor(rand() * (50-15+1)+15);