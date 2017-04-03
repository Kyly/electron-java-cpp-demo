#ifdef _DLL
#define EXTERN_HEADER extern "C" __declspec(dllexport)
#define WINAPI __stdcall
#else
#define EXTERN_HEADER extern "C"
#endif

EXTERN_HEADER void helloWorld(const char*, char**);

EXTERN_HEADER void cleanUp(void*);