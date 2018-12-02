%%E6

%Inicializar
n=250000;
k=3;
DentroBloom=0;
i=0;

bloom = initialize(n);

fich = fopen("testeGutenberg.txt");
insertCounterFilter(fich,bloom,k,n);
fclose(fich);

fich = fopen("testeGutenberg.txt");
res = isMemberCounterFilter(fich,bloom,k,n);
fclose(fich);