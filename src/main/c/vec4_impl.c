#include <org_lwtk_math_exp_Vec4.h>
#include <xmmintrin.h>

#define jvec4_nadd Java_org_lwtk_math_exp_Vec4_nadd

JNIEXPORT void JNICALL jvec4_nadd(JNIEnv *, jclass, jlong a, jlong b, jlong dest)
{
    const __m128 va = _mm_load_ps((float *)a);
    const __m128 vb = _mm_load_ps((float *)b);
    const __m128 vd = _mm_add_ps(va, vb);
    _mm_store_ps((float *)dest, vd);
}
