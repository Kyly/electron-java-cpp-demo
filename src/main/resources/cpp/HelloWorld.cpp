#include <cstdlib>
#include <cstring>
#include <string>
#include "HelloWorld.hpp"

using namespace std;

EXTERN_HEADER void helloWorld(const char* inputCharPtr, char** outputCharPtr)
{
    string hello = "Hello, ";
    hello += inputCharPtr;
    const char * greeting = hello.c_str();
    size_t greetingSize = strlen(inputCharPtr);

	*outputCharPtr = (char*)malloc(sizeof(char) * greetingSize);
	memset(*outputCharPtr, 0, sizeof(char) * greetingSize);

	strcpy(*outputCharPtr, greeting);
}

EXTERN_HEADER void cleanUp(void * pointer) {
    free(pointer);
}