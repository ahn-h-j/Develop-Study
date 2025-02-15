### 조건문

- if문
    
    ```java
    if(조건문){
    	body;
    }
    ```
    
- if else 문
    
    ```java
    if(조건문){
    	body;
    else{
    	body;
    }
    ```
    
- else if 문
    
    ```java
    if(조건문){
    	body;
    else if(조건문){
    	body;
    else{
    	body;
    }
    ```
### 반복문

- for문
    
    ```java
    for(초기화; 조건식; 증감식){
    	for문 body;
    }
    ```
    
- while문
    
    ```java
    while(조건식){
    	body;
    	//조건식을 종료시킬 수 있게 구성되어야 함
    }
    ```
    
- do-while문
    - 무조건 한번은 수행하게 되는 반복문
    
    ```java
    do{
     body;
    }while(조건식);
    ```
    ### Switch

- 여러 값에 대해 조건을 비교하고 일치하는 경우 해당 코드를 실행
- 가독성 측면에서 좋음

### Switch vs if-else

⚠️ GPT 답변이기에 명확하지 않을 수 있습니다.

- **if-else**
    - 모든 조건문을 순차적으로 평가
    - 조건이 많을 수록 성능이 떨어짐
    - 조건이 복잡하거나 범위 비교가 필요한 경우 적합
- **switch**
    - 하나의 값을 기준으로 case를 비교
    - 정확한 값으로 분기를 처리하고 분기 조건이 많고 연속적인 경우 적합
    - 컴파일러가 jump table, hash table을 생성
        - jump table : switch에 사용된 case 값들이 연속적일 경우, 배열 index처럼 빠르게 접근 가능
        - SwitchJumpTable.java
            
            ```java
            public class SwitchJumpTable {
                public static void main(String[] args) {
                    int value = 3;
                    switch (value) {
                        case 1:
                            System.out.println("One");
                            break;
                        case 2:
                            System.out.println("Two");
                            break;
                        case 3:
                            System.out.println("Three");
                            break;
                        case 4:
                            System.out.println("Four");
                            break;
                        case 5:
                            System.out.println("Five");
                            break;
                        default:
                            System.out.println("Default");
                    }
                }
            }
            ```
            
        - javap -c SwitchJumpTable로 코드 디컴파일
            - tableswitch : table 사용
            
            ```java
            Compiled from "SwitchJumpTable.java"
            public class SwitchJumpTable {
              public SwitchJumpTable();
                Code:
                   0: aload_0
                   1: invokespecial #1                  // Method java/lang/Object."<init>":()V
                   4: return
            
              public static void main(java.lang.String[]);
                Code:
                   0: iconst_3
                   1: istore_1
                   2: iload_1
                   3: tableswitch   { // 1 to 5
                                 1: 36
                                 2: 47
                                 3: 58
                                 4: 69
                                 5: 80
                           default: 91
                      }
                  36: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
                  39: ldc           #13                 // String One
                  41: invokevirtual #15                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
                  44: goto          99
                  47: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
                  50: ldc           #21                 // String Two
                  52: invokevirtual #15                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
                  55: goto          99
                  58: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
                  61: ldc           #23                 // String Three
                  63: invokevirtual #15                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
                  66: goto          99
                  69: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
                  72: ldc           #25                 // String Four
                  74: invokevirtual #15                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
                  77: goto          99
                  80: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
                  83: ldc           #27                 // String Five
                  85: invokevirtual #15                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
                  88: goto          99
                  91: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
                  94: ldc           #29                 // String Default
                  96: invokevirtual #15                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
                  99: return
            }
            ```
            
        - lookup table : switch에 사용된 case 값들이 불연속적인 경우, lookup table을 통해 빠르게 접근 가능
            - SwitchLookupTable.java
                
                ```java
                public class SwitchLookupTable {
                    public static void main(String[] args) {
                        int code = 42;
                        switch (code) {
                            case 10:
                                System.out.println("Code 10");
                                break;
                            case 20:
                                System.out.println("Code 20");
                                break;
                            case 42:
                                System.out.println("Code 42");
                                break;
                            case 99:
                                System.out.println("Code 99");
                                break;
                            default:
                                System.out.println("Unknown Code");
                        }
                    }
                }
                
                ```
                
            - javap -c SwitchJumpTable로 코드 디컴파일
                - lookupswitch : lookup table 사용
                
                ```java
                Compiled from "SwitchLookupTable.java"
                public class SwitchLookupTable {
                  public SwitchLookupTable();
                    Code:
                       0: aload_0
                       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
                       4: return
                
                  public static void main(java.lang.String[]);
                    Code:
                       0: bipush        42
                       2: istore_1
                       3: iload_1
                       4: lookupswitch  { // 4
                                    10: 48
                                    20: 59
                                    42: 70
                                    99: 81
                               default: 92
                          }
                      48: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
                      51: ldc           #13                 // String Code 10
                      53: invokevirtual #15                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
                      56: goto          100
                      59: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
                      62: ldc           #21                 // String Code 20
                      64: invokevirtual #15                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
                      67: goto          100
                      70: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
                      73: ldc           #23                 // String Code 42
                      75: invokevirtual #15                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
                      78: goto          100
                      81: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
                      84: ldc           #25                 // String Code 99
                      86: invokevirtual #15                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
                      89: goto          100
                      92: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
                      95: ldc           #27                 // String Unknown Code
                      97: invokevirtual #15                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
                     100: return
                }
                
                ```
                

### Break

- 반복문, switch문에서 사용되어 해당 블록을 즉시 빠져나가도록 지원하는 키워드
    
    ```java
    while(조건){
    	break;
    }
    
    -----------------

    do{
    	break;
    }while(조건);

    -----------------
    
    switch(변수){
    	case 1: 
    		break;
    }

    -----------------
    
    for( ; ;){
    	break;
    }
    ```
    
