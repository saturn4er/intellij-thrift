namespace foo bar

typedef    i32      A
service    SomeService     {
 oneway   void    methodA(
1:    i32   f,
2: i32 b,
)
throws(
1:    i32   f,
2: i32 b,
3: i32 c,     4: i32 d,
)
}


struct    I    {
1 : map<i32, i32> a = {10:20,    30:40}  ;
2   : list<i32> a = {10:20,    30:40}  ;
3: set<i32> a = {10:20,    30:40}     ;
}
struct    B    {
1: map<i32, i32> a = 10;
2: list<i32> a =   [1 , 2, 3];

}
